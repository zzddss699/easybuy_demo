package com.zds.easybuy_demo.service;

import com.zds.easybuy_demo.entity.Order;
import com.zds.easybuy_demo.entity.User;
import com.zds.easybuy_demo.util.ShoppingCart;

public interface OrderService {

    Order payShoppingCart(ShoppingCart cart, User user, String address);

}
