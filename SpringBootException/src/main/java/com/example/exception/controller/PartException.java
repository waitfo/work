package com.example.exception.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PartException {

    @RequestMapping("/index")
    public String error(){
        int i=1/0;
        return "index";
    }

    @RequestMapping("/ex2")
    public String error2(){
        int[] ints = new int[10];
        int i=ints[10];
        return "index";
    }

    //局部异常处理
//    @ExceptionHandler(Exception.class)
//    @ResponseBody
//    public String exHandler(Exception e){
//        //判断发生异常的类型是除0异常则做出响应
//        if(e instanceof ArithmeticException){
//            return "发生了除0异常";
//        }
//        if(e instanceof ArrayIndexOutOfBoundsException){
//            return "发生了数组越界异常";
//        }
//        //未知异常做出响应
//        return "发生了未知异常";
//    }
}
