package com.zds.easybuy_demo.service;

import com.zds.easybuy_demo.entity.Product;
import com.zds.easybuy_demo.entity.ProductCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductService {

    List<Product> selectByLevelId(@Param("Level1Id") Integer id);

    List<Product> selectLikeName(@Param("name") String name,@Param("type") Integer type,@Param("id") Integer id);

    Product selectByPrimaryKey(Integer id);

    Integer updateStock(@Param("id") Integer id,@Param("quantity") Integer quantity);
}
