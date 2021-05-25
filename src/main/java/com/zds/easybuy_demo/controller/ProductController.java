package com.zds.easybuy_demo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zds.easybuy_demo.baseDao.RespBean;
import com.zds.easybuy_demo.entity.Product;
import com.zds.easybuy_demo.entity.ProductCategory;
import com.zds.easybuy_demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName ProductController
 * @Description TODO
 * @Author 157
 * @Date 2021/4/28 8:46
 * @Version 1.0
 **/
@RestController
@RequestMapping(value = "/pro")
public class ProductController {

    @Autowired
    private ProductService productService;

    /*
     * @Author 157
     * @Description //根据分类1的id查询分类1下的所有商品
     * @MethodName selectByLevelId
     * @Date 8:49 2021/4/28
     * @Param [id]
     * @return com.zds.easybuy_demo.baseDao.RespBean
     **/
    @GetMapping(value = "/ByLevelId")
    public RespBean selectByLevelId(@RequestParam Integer id){
        List<Product> list = productService.selectByLevelId(id);
        return RespBean.success("查询成功",list);
    }

    @GetMapping(value = "/LikeName")
    public RespBean selectLikeName(@RequestParam(defaultValue = "1") Integer page,
                                   @RequestParam(required = false) String name,
                                   @RequestParam(required = false) String type,
                                   @RequestParam(required = false) String id){
        Integer typely;
        if (type == null || type.equals("") || type.equals("null")) {
            typely = 0;
        }else {
            typely = Integer.parseInt(type);
        }
        Integer idly;
        if (id == null || id.equals("") || id.equals("null")) {
            idly = 0;
        }else {
            idly = Integer.parseInt(id);
        }
        PageHelper.startPage(page,20);
        List<Product> list = productService.selectLikeName(name,typely,idly);
        PageInfo<Product> productPageInfo = new PageInfo<>(list);
        return RespBean.success("查询成功",productPageInfo);
    }

    @GetMapping(value = "/selectById")
    public RespBean selectByPrimaryKey(@RequestParam Integer id){
        Product product = productService.selectByPrimaryKey(id);
        return RespBean.success("查询成功",product);
    }
}
