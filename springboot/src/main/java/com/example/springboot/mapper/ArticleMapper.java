package com.example.springboot.mapper;

import com.example.springboot.controller.request.BaseRequest;
import com.example.springboot.entity.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {

//    @Select("select * from admin")//从数据库导出来
    List<Article> list();//映射到该函数输出出去 list查出来多个方便映射

    List<Article> listByCondition(BaseRequest baseRequest);

    void save(Article user);

    Article getById(Integer id);

    void updateById(Article user);

    void deleteById(Integer id);

}
