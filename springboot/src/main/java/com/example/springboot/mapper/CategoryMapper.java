package com.example.springboot.mapper;

import com.example.springboot.controller.request.BaseRequest;
import com.example.springboot.controller.request.LoginRequest;
import com.example.springboot.entity.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {

//    @Select("select * from admin")//从数据库导出来
    List<Category> list();//映射到该函数输出出去 list查出来多个方便映射

    List<Category> listByCondition(BaseRequest baseRequest);

    void save(Category user);

    Category getById(Integer id);

    void updateById(Category user);

    void deleteById(Integer id);
}
