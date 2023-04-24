package com.example.springboot.controller.request;

import lombok.Data;

@Data
public class ArticlePageRequest extends BaseRequest{
    private String name;
}