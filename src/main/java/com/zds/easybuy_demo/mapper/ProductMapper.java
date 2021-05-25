package com.zds.easybuy_demo.mapper;

import com.zds.easybuy_demo.baseDao.IBaseDao;
import com.zds.easybuy_demo.entity.Product;
import com.zds.easybuy_demo.entity.ProductCategory;

import java.util.List;

/**
 * @ClassName ProductMapper
 * @Description TODO
 * @Author 157
 * @Date 2021/4/28 8:30
 * @Version 1.0
 **/
public interface ProductMapper extends IBaseDao<Product> {

    List<Product> selectByLevelId(Integer id);

    List<Product> selectLikeName(String name,Integer type,Integer id);

    Integer updateStock(Integer id, Integer quantity);

}
