package com.zds.easybuy_demo.service;

import com.zds.easybuy_demo.entity.News;

import java.util.List;

public interface NewsService {

    List<News> selectAll();

    List<News> selectTitle();

    int insert(News news);

    int updateByPrimaryKey(News news);

    int deleteByPrimaryKey(Integer id);

    News selectByPrimaryKey(Integer id);

}
