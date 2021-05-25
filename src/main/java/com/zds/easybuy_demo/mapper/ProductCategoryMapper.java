package com.zds.easybuy_demo.mapper;

import com.zds.easybuy_demo.baseDao.IBaseDao;
import com.zds.easybuy_demo.entity.ProductCategory;

import java.util.List;

public interface ProductCategoryMapper extends IBaseDao<ProductCategory> {

    List<ProductCategory> selectByParentId(Integer id);

    List<ProductCategory> selectByTypeId(Integer id);

}
