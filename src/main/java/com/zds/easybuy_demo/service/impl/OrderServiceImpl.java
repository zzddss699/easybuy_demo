package com.zds.easybuy_demo.service.impl;

import com.zds.easybuy_demo.entity.Order;
import com.zds.easybuy_demo.entity.OrderDetail;
import com.zds.easybuy_demo.entity.User;
import com.zds.easybuy_demo.mapper.OrderDetailMapper;
import com.zds.easybuy_demo.mapper.OrderMapper;
import com.zds.easybuy_demo.mapper.ProductMapper;
import com.zds.easybuy_demo.service.OrderService;
import com.zds.easybuy_demo.service.ProductService;
import com.zds.easybuy_demo.util.ShoppingCart;
import com.zds.easybuy_demo.util.ShoppingCartItem;
import com.zds.easybuy_demo.util.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @ClassName OrderServiceImpl
 * @Description TODO
 * @Author 157
 * @Date 2021/5/14 11:55
 * @Version 1.0
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private ProductService productService;

    @Resource
    private OrderDetailMapper orderDetailMapper;

    @Resource
    private OrderMapper orderMapper;

    @Override
    public Order payShoppingCart(ShoppingCart cart, User user, String address) {
        Order order = new Order();
        order.setUserId(user.getId());
        order.setLoginName(user.getLoginName());
        order.setUserAddress(address);
        order.setCreateTime(new Date());
        order.setCost(cart.getSum());
        order.setSerialNumber(StringUtils.randomUUID());
        orderMapper.insert(order);
        //增加订单对应的明细信息
        for (ShoppingCartItem item : cart.getItems()){
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderId(order.getId());
            orderDetail.setProductId(item.getProduct().getId());
            orderDetail.setProduct(item.getProduct());
            orderDetail.setCost(item.getCost());
            orderDetail.setQuantity(item.getQuantity());
            orderDetailMapper.insert(orderDetail);
            //更新商品表的库存
            productService.updateStock(item.getProduct().getId(), item.getQuantity());
        }
        return order;
    }
}
