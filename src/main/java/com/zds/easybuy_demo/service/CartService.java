package com.zds.easybuy_demo.service;

import com.zds.easybuy_demo.util.ShoppingCart;

public interface CartService {

    public ShoppingCart modifyShoppingCart(Integer productId,Integer quantity,ShoppingCart cart);

    public ShoppingCart calculate(ShoppingCart cart);

    //public List<UserCart> userCartAll();

}
