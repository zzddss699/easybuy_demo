package com.zds.easybuy_demo.service.impl;

import com.zds.easybuy_demo.entity.Product;
import com.zds.easybuy_demo.entity.ProductCategory;
import com.zds.easybuy_demo.mapper.ProductMapper;
import com.zds.easybuy_demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName ProductServiceImpl
 * @Description TODO
 * @Author 157
 * @Date 2021/4/28 8:44
 * @Version 1.0
 **/
@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductMapper productMapper;

    @Override
    public List<Product> selectByLevelId(Integer id) {
        return productMapper.selectByLevelId(id);
    }

    @Override
    public List<Product> selectLikeName(String name, Integer type, Integer id) {
        return productMapper.selectLikeName(name,type,id);
    }

    @Override
    public Product selectByPrimaryKey(Integer id) {
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer updateStock(Integer id, Integer quantity) {
        Product product = selectByPrimaryKey(id);
        Integer stock = product.getStock()-quantity;
        return productMapper.updateStock(id, stock);
    }

}
