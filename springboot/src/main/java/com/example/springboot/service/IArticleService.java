package com.example.springboot.service;

import com.example.springboot.controller.request.ArticlePageRequest;
import com.example.springboot.controller.request.BaseRequest;
import com.example.springboot.entity.Article;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IArticleService {

    List<Article> list();

    PageInfo<Article> page(BaseRequest baseRequest);

    void save(Article obj);

    Article getById(Integer id);

    void update(Article obj);

    void deleteById(Integer id);
}