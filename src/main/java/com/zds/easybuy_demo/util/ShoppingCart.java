package com.zds.easybuy_demo.util;

import com.zds.easybuy_demo.baseDao.RespBean;
import com.zds.easybuy_demo.entity.Product;
import com.zds.easybuy_demo.entity.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ShoppingCart
 * @Description 购物车
 * @Author 157
 * @Date 2021/5/11 12:20
 * @Version 1.0
 **/
public class ShoppingCart implements Serializable {
    /*private User user = new User();*/
    public List<ShoppingCartItem> items = new ArrayList<ShoppingCartItem>();
    private Double sum;

    /*//获取购物车所属用户
    public User getUser() {
        return user;
    }*/

    //获取购物车中的所有商品
    public List<ShoppingCartItem> getItems() {
        return items;
    }

    //添加一项
    public RespBean addItem(Product product,Integer quantity){
        int flag = 0;
        for (int i = 0; i < items.size(); i++) {
            //判断购物车中是否已有此商品，如果有则累计数量
            if (items.get(i).getProduct().getId().equals(product.getId())){
                if (items.get(i).getQuantity()+quantity>product.getStock()){
                    return RespBean.error("商品数量不足");
                }else {
                    items.get(i).setQuantity(items.get(i).getQuantity()+quantity);
                    flag = 1;
                }
            }
        }
        if (quantity>product.getStock()){
            return RespBean.error("商品数量不足");
        }
        if (flag == 0){
            items.add(new ShoppingCartItem(product,quantity));
        }
        return RespBean.success("添加商品到购物车成功");
    }

    //移除一项
    public void removeItem(int index){
        items.remove(index);
    }

    //修改数量
    public void modifyQuantity(int index, Integer quantity){
        items.get(index).setQuantity(quantity);
    }

    //计算总价格
    public float getTotalCost(){
        float sum = 0;
        for (ShoppingCartItem item : items){
            sum = sum + item.getCost();
        }
        return sum;
    }

    /*public void setUser(User user) {
        this.user = user;
    }*/

    public void setItems(List<ShoppingCartItem> items) {
        this.items = items;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }
}
