package com.example.springboot.entity;

import lombok.Data;

import java.util.List;

@Data
public class Category {
    private Integer id;
    private String name;
    private String remark;
    private Integer pid;

//    private List<Category> children;
}
