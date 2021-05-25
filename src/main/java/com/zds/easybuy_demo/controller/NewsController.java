package com.zds.easybuy_demo.controller;

import com.zds.easybuy_demo.baseDao.RespBean;
import com.zds.easybuy_demo.entity.News;
import com.zds.easybuy_demo.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @GetMapping(value = "/selectTitle")
    public RespBean selectTitle(){
        List<News> list = newsService.selectTitle();
        return RespBean.success("查询成功",list);
    }


}
