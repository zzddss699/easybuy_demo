package com.zds.easybuy_demo.service;

import com.zds.easybuy_demo.entity.ProductCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductCategoryService {

    List<ProductCategory> selectAll();

    ProductCategory selectByPrimaryKey(Integer id);

    List<ProductCategory> selectByParentId(@Param("parentId")Integer id);

}
