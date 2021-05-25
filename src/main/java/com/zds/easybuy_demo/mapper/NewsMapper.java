package com.zds.easybuy_demo.mapper;

import com.zds.easybuy_demo.baseDao.IBaseDao;
import com.zds.easybuy_demo.entity.News;

import java.util.List;

public interface NewsMapper extends IBaseDao<News> {

    List<News> selectTitle();

}
