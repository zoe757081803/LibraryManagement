package com.example.springboot.controller.dto;

import lombok.Data;

@Data
public class LoginDTO {
    private Integer id;
    private String username;
//    密码不在登录页面返回，不安全
}
