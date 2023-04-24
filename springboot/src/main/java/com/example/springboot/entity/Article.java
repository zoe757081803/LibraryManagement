package com.example.springboot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Date;

@Data
public class Article{
    /**
     * id
     */
    private Integer id;

    /**
     * name
     */
    private String name;

    /**
     * author
     */
    private String author;

    /**
     * abstract
     */
    private String digest;

    /**
     * publishdate
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone = "GMT+8")
    private Date publishdate;

    /**
     * source
     */
    private String source;

    /**
     * grade
     */
    private String grade;

    /**
     * review
     */
    private String review;

    /**
     * provider
     */
    private String provider;

    /**
     * 分类
     */
    private String category;

    /**
     * text
     */
    private String text;


}