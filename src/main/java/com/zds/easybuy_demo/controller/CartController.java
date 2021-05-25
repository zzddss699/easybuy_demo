package com.zds.easybuy_demo.controller;

import com.zds.easybuy_demo.baseDao.RespBean;
import com.zds.easybuy_demo.entity.Order;
import com.zds.easybuy_demo.entity.Product;
import com.zds.easybuy_demo.entity.User;
import com.zds.easybuy_demo.entity.UserAddress;
import com.zds.easybuy_demo.service.*;
import com.zds.easybuy_demo.util.EmptyUtils;
import com.zds.easybuy_demo.util.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName CartController
 * @Description 购物车控制类
 * @Author 157
 * @Date 2021/5/11 12:07
 * @Version 1.0
 **/
@RestController
@RequestMapping(value = "/cart")
public class CartController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductCategoryService productCategoryService;
    @Autowired
    private UserService userService;
    @Autowired
    private CartService cartService;
    @Autowired
    private UserAddressService userAddressService;
    @Autowired
    private OrderService orderService;

    //获取购物车
    private ShoppingCart cart = new ShoppingCart();
    //获取用户
    private User user = new User();
    /*
     * @Author 157
     * @Description //添加到购物车
     * @MethodName add
     * @Date 12:10 2021/5/11
     * @Param []
     * @return com.zds.easybuy_demo.baseDao.RespBean
     **/
    @PostMapping(value = "add")
    public RespBean add(@RequestParam Integer entityId,@RequestParam Integer quantity){
        //查询出商品
        Product product = productService.selectByPrimaryKey(entityId);
        if (quantity>product.getStock()){
            return RespBean.error("商品数量不足.");
        }
        //往购物车放置商品
        RespBean respBean = cart.addItem(product, quantity);
        if (respBean.getStatus()==200){
            cart.setSum((EmptyUtils.isEmpty(cart.getSum()) ? 0.0 : cart.getSum()) + (product.getPrice() * quantity * 1.0));
        }
        return RespBean.success("添加购物车成功",cart);
    }

    /*
     * @Author 157
     * @Description //刷新购物车
     * @MethodName refreshCart
     * @Date 8:27 2021/5/12
     * @Param []
     * @return com.zds.easybuy_demo.baseDao.RespBean
     **/
    @GetMapping(value = "refreshCart")
    public RespBean refreshCart(){
        cart = cartService.calculate(cart);
        return RespBean.success("刷新购物车成功", this.cart);//全部的商品
    }

    /*
     * @Author 157
     * @Description //修改购物车信息
     * @MethodName modifyCart
     * @Date 11:29 2021/5/13
     * @Param [entityId, quantity]
     * @return com.zds.easybuy_demo.baseDao.RespBean
     **/
    @GetMapping(value = "modCart")
    public RespBean modCart(@RequestParam Integer entityId,@RequestParam Integer quantity){
        Product product = productService.selectByPrimaryKey(entityId);
        if (EmptyUtils.isNotEmpty(quantity)){
            if (quantity>product.getStock()){
                return RespBean.error("商品数量不足");
            }
        }
        cartService.modifyShoppingCart(entityId,quantity,cart);
        return RespBean.success("修改购物车信息成功",cart);
    }

    @GetMapping(value = "settlement1")
    public RespBean settlement1(){
        return RespBean.success("查询购物车商品清单",cart);
    }

    @GetMapping(value = "settlement2")
    public RespBean settlement2(@RequestParam Integer id){
        List<UserAddress> userAddressList = userAddressService.queryUserAddressList(id);
        return RespBean.success("查询用户地址列表成功",userAddressList);
    }

    /*
     * @Description //生成订单
     * @MethodName settlement3
     * @Date 15:05 2021/5/18
     * @Param [addressId, newAddress, newRemark]
     * @return com.zds.easybuy_demo.baseDao.RespBean
     **/
    @GetMapping(value = "settlement3")
    public RespBean settlement3(@RequestParam Integer addressId,
                                @RequestParam(required = false) String newAddress,
                                @RequestParam(required = false) String newRemark){
        user = userService.getLoginUser();
        cart = cartService.calculate(cart);
        UserAddress userAddress = new UserAddress();
        if (addressId==(-1)){
            userAddress.setAddress(newAddress);
            userAddress.setRemark(newRemark);
            userAddress.setUserId(user.getId());
            userAddressService.insert(userAddress);
        } else {
            userAddress = userAddressService.selectByPrimaryKey(addressId);
        }
        //生成订单
        Order order = orderService.payShoppingCart(cart, user, userAddress.getAddress());
        clearCart();
        return RespBean.success("生成订单成功",order);
    }

    /*
     * @Author 157
     * @Description //清空购物车
     * @MethodName clearCart
     * @Date 8:40 2021/5/12
     * @Param [cart]
     * @return com.zds.easybuy_demo.baseDao.RespBean
     **/
    @RequestMapping(value = "clearCart")
    public RespBean clearCart() {
        cart.getItems().clear();
        return RespBean.success("清空购物车执行成功");
    }

}
