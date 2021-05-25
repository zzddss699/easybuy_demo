package com.zds.easybuy_demo.controller;

import com.zds.easybuy_demo.baseDao.RespBean;
import com.zds.easybuy_demo.util.ProList;
import com.zds.easybuy_demo.entity.Product;
import com.zds.easybuy_demo.entity.ProductCategory;
import com.zds.easybuy_demo.service.ProductCategoryService;
import com.zds.easybuy_demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ProductCategoryController
 * @Description TODO
 * @Author 157
 * @Date 2021/4/27 13:29
 * @Version 1.0
 **/
@RestController
@RequestMapping(value = "/pC")
public class ProductCategoryController {
    @Autowired
    private ProductCategoryService productCategoryService;

    @Autowired
    private ProductService productService;
    /*
     * @Author 157
     * @Description //TODO
     * @MethodName selectAll
     * @Date 16:24 2021/4/27
     * @Param []
     * @return com.zds.easybuy_demo.baseDao.RespBean
     **/
    /*@GetMapping(value = "/selectAll")
    public RespBean selectAll(){
        List<ProductCategory> list = productCategoryService.selectAll();
        return RespBean.success("查询成功",list);
    }*/

    /*
     * @Author 157
     * @Description //TODO
     * @MethodName selectByPrimaryKey
     * @Date 16:26 2021/4/27
     * @Param [id]
     * @return com.zds.easybuy_demo.baseDao.RespBean
     **/
    /*@GetMapping(value = "/selectId")
    public RespBean selectByPrimaryKey(@RequestParam Integer id){
        ProductCategory productCategory = productCategoryService.selectByPrimaryKey(id);
        return RespBean.success("查询成功",productCategory);
    }

    @GetMapping(value = "/ByParentId")
    public RespBean selectByParentId(@RequestParam Integer id){
        List<ProductCategory> list = productCategoryService.selectByParentId(id);
        return RespBean.success("查询成功",list);
    }*/

    @GetMapping(value = "/Level")
    public RespBean selectByParentId2(){
        List<ProductCategory> list = productCategoryService.selectByParentId(0);
        for (ProductCategory p:list) {
            //ProductCategory productCategory = new ProductCategory();
            List<ProductCategory> list1 = productCategoryService.selectByParentId(p.getId());
            p.setCategories(list1);
            for (ProductCategory c:list1) {
                List<ProductCategory> list2 = productCategoryService.selectByParentId(c.getId());
                c.setCategories(list2);
            }
        }
        return RespBean.success("查询成功",list);
    }

    @GetMapping(value = "/findAllLevel")
    public RespBean findAllLevel(){
        List list = new ArrayList();
        List<ProductCategory> list1 = productCategoryService.selectByParentId(0);
        for (int i = 0; i < list1.size(); i++) {
            ProList proList = new ProList();
            proList.setLevel1(list1.get(i).getName());
            List<ProductCategory> list2 = productCategoryService.selectByParentId(list1.get(i).getId());
            List listx2 = new ArrayList();
            for (int j = 0; j < list2.size(); j++) {
                listx2.add(list2.get(j).getName());
            }
            proList.setLevel2(listx2);
            List<Product> products = productService.selectByLevelId(list1.get(i).getId());
            proList.setLevel3(products);
            list.add(i,proList);
        }
        return RespBean.success("查询成功",list);
    }

    /*public static void main(String[] args) {
        findAllLevel();
    }*/
}
