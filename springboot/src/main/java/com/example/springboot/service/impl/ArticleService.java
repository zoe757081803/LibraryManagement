package com.example.springboot.service.impl;

import com.example.springboot.controller.request.BaseRequest;
import com.example.springboot.entity.Article;
import com.example.springboot.mapper.ArticleMapper;
import com.example.springboot.service.IArticleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class ArticleService implements IArticleService {

    @Resource
    ArticleMapper articleMapper;


    @Override
    public List<Article> list() {
        return articleMapper.list();
    }

    @Override
    public PageInfo<Article> page(BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNum(), baseRequest.getPageSize());
        // 自关联查询
        List<Article> articles = articleMapper.listByCondition(baseRequest);
        return new PageInfo<>(articles);
    }

    @Override
    public void save(Article obj) {
        articleMapper.save(obj);
    }

    @Override
    public Article getById(Integer id) {
        return articleMapper.getById(id);
    }

    @Override
    public void update(Article obj) {
        articleMapper.updateById(obj);
    }

    @Override
    public void deleteById(Integer id) {
        articleMapper.deleteById(id);
    }

}