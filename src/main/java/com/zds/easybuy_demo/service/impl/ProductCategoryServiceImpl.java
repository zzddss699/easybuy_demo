package com.zds.easybuy_demo.service.impl;

import com.zds.easybuy_demo.entity.ProductCategory;
import com.zds.easybuy_demo.mapper.ProductCategoryMapper;
import com.zds.easybuy_demo.mapper.ProductMapper;
import com.zds.easybuy_demo.service.ProductCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName ProductCategoryServiceImpl
 * @Description TODO
 * @Author 157
 * @Date 2021/4/27 13:25
 * @Version 1.0
 **/
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Resource
    private ProductCategoryMapper productCategoryMapper;

    @Resource
    private ProductMapper productMapper;

    @Override
    public List<ProductCategory> selectAll() {
        return productCategoryMapper.selectAll();
    }

    @Override
    public ProductCategory selectByPrimaryKey(Integer id) {
        return productCategoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ProductCategory> selectByParentId(Integer id) {
        return productCategoryMapper.selectByParentId(id);
    }
}
