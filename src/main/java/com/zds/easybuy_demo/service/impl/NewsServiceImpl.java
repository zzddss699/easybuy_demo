package com.zds.easybuy_demo.service.impl;

import com.zds.easybuy_demo.entity.News;
import com.zds.easybuy_demo.mapper.NewsMapper;
import com.zds.easybuy_demo.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class NewsServiceImpl implements NewsService {
    @Resource
    private NewsMapper newsMapper;

    @Override
    public List<News> selectAll() {
        return newsMapper.selectAll();
    }

    @Override
    public List<News> selectTitle() {
        return newsMapper.selectTitle();
    }

    @Override
    public int insert(News news) {
        return newsMapper.insert(news);
    }

    @Override
    public int updateByPrimaryKey(News news) {
        return newsMapper.updateByPrimaryKey(news);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return newsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public News selectByPrimaryKey(Integer id) {
        return newsMapper.selectByPrimaryKey(id);
    }
}
