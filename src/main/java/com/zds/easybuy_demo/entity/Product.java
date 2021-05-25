package com.zds.easybuy_demo.entity;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @ClassName product
 * @Description easybuy_product
 * @Author 157
 * @Date 2021/4/27 12:01
 * @Version 1.0
 **/
@Repository
@Table(name = "easybuy_product")
public class Product implements Serializable {

    //主键 自动递增
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;//ID

    //名称
    @Column(name = "name")
    private String name;//名称

    //描述
    @Column(name = "description")
    private String description;//描述

    //价格
    @Column(name = "price")
    private Float price;//价格

    //库存
    @Column(name = "stock")
    private Integer stock;//库存

    //分类1
    @Column(name = "categoryLevel1Id")
    private Integer categoryLevel1Id;//一级分类

    //分类2
    @Column(name = "categoryLevel2Id")
    private Integer categoryLevel2Id;//二级分类

    //分类3
    @Column(name = "categoryLevel3Id")
    private Integer categoryLevel3Id;//三级分类

    //文件名称
    @Column(name = "fileName")
    private String fileName;//图片名称

    /*//是否删除(1：删除 0：未删除)
    @Column(name = "isDelete")
    private Integer isDelete;*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getCategoryLevel1Id() {
        return categoryLevel1Id;
    }

    public void setCategoryLevel1Id(Integer categoryLevel1Id) {
        this.categoryLevel1Id = categoryLevel1Id;
    }

    public Integer getCategoryLevel2Id() {
        return categoryLevel2Id;
    }

    public void setCategoryLevel2Id(Integer categoryLevel2Id) {
        this.categoryLevel2Id = categoryLevel2Id;
    }

    public Integer getCategoryLevel3Id() {
        return categoryLevel3Id;
    }

    public void setCategoryLevel3Id(Integer categoryLevel3Id) {
        this.categoryLevel3Id = categoryLevel3Id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", categoryLevel1Id=" + categoryLevel1Id +
                ", categoryLevel2Id=" + categoryLevel2Id +
                ", categoryLevel3Id=" + categoryLevel3Id +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
