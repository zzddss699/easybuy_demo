package com.zds.easybuy_demo.entity;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @ClassName OrderDetail
 * @Description easybuy_order_detail
 * @Author 157
 * @Date 2021/5/14 11:37
 * @Version 1.0
 **/
@Repository
@Table(name = "easybuy_order_detail")
public class OrderDetail implements Serializable {
    //主键
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //订单主键
    @Column(name = "orderId")
    private Integer orderId;

    //商品主键
    @Column(name = "productId")
    private Integer productId;

    //数量
    @Column(name = "quantity")
    private Integer quantity;

    //消费
    @Column(name = "cost")
    private Float cost;

    //商品
    private Product product;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
