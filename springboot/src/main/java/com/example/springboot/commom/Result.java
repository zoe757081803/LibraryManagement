package com.example.springboot.commom;

import lombok.Data;

//包装后台数据,显示错误信息
@Data
public class Result {
    //设置常量信息
    private static final String SUCCESS_CODE="200";
    private static final String ERROR_CODE="-1";

    private String code;//返回代码信息
    private Object data;
    private String msg;//存放错误信息

    public static Result success(){
        Result result = new Result();
        result.setCode(SUCCESS_CODE);
        return result;
    }
    public static Result success(Object data){
        Result result = new Result();
        result.setCode(SUCCESS_CODE);
        result.setData(data);
        return result;
    }
    public static Result error(String msg){
        Result result = new Result();
        result.setCode(ERROR_CODE);
        result.setMsg(msg);//返回错误信息
        return result;
    }
}
