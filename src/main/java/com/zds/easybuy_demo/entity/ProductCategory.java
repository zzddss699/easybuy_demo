package com.zds.easybuy_demo.entity;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @ClassName ProductCategory
 * @Description easybuy_product_category表
 * @Author 157
 * @Date 2021/4/27 12:59
 * @Version 1.0
 **/
@Repository
@Table(name = "easybuy_product_category")
public class ProductCategory implements Serializable {
    //主键
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;//ID

    //名称
    @Column(name = "name")
    private String name;//名称

    //父级目录id
    @Column(name = "parentId")
    private Integer parentId;//父级ID

    //级别(1:一级 2：二级 3：三级)
    @Column(name = "type")
    private Integer type;//分类级别

    //图标
    @Column(name = "iconClass")
    private String iconClass;

    private List<ProductCategory> categories;

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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getIconClass() {
        return iconClass;
    }

    public void setIconClass(String iconClass) {
        this.iconClass = iconClass;
    }

    public List<ProductCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<ProductCategory> categories) {
        this.categories = categories;
    }
}
