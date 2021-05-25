package com.zds.easybuy_demo.service.impl;

import com.zds.easybuy_demo.service.CartService;
import com.zds.easybuy_demo.service.UserService;
import com.zds.easybuy_demo.util.EmptyUtils;
import com.zds.easybuy_demo.util.ShoppingCart;
import com.zds.easybuy_demo.util.ShoppingCartItem;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName CartServiceImpl
 * @Description 订单
 * @Author 157
 * @Date 2021/5/11 15:43
 * @Version 1.0
 **/
@Service
public class CartServiceImpl implements CartService {

    @Resource
    private UserService userService;

    @Override
    public ShoppingCart modifyShoppingCart(Integer productId, Integer quantity, ShoppingCart cart) {
        if (!EmptyUtils.isEmpty(quantity)){
            //便利购物车寻找该商品 修改其数量
            for (ShoppingCartItem item : cart.getItems()){
                if (item.getProduct().getId().equals(productId)){
                    if (quantity == 0 || quantity < 0){
                        cart.getItems().remove(item);
                        break;
                    } else {
                        item.setQuantity(quantity);
                    }
                }
            }
        }
        //重新计算金额
        calculate(cart);
        return cart;
    }

    /*
     * @Author 157
     * @Description //核算购物车的金额
     * @MethodName calculate
     * @Date 15:48 2021/5/11
     * @Param [cart]
     * @return com.zds.easybuy_demo.util.ShoppingCart
     **/
    @Override
    public ShoppingCart calculate(ShoppingCart cart) {
        double sum = 0.0;
        for (ShoppingCartItem item : cart.getItems()) {
            sum = sum + item.getQuantity() * item.getProduct().getPrice();
            item.setCost(item.getQuantity() * item.getProduct().getPrice());
        }
        cart.setSum(sum);
        return cart;
    }

    /*@Override
    public List<UserCart> userCartAll() {
        List<UserCart> userCarts = new ArrayList<UserCart>();
        UserCart userCart = new UserCart();
        List<User> users = userService.selectAll();
        for (int i = 0; i < users.size(); i++) {
            userCart.setUser(users.get(i));
            userCarts.add(userCart);
        }
        return userCarts;
    }*/

}
