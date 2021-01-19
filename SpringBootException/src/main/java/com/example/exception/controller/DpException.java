package com.example.exception.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//会和自定义的MyBasicErrorController中的路径重合，所以会报错
//@RestController
//@RequestMapping("/error")
public class DpException {

//    @RequestMapping("/500")
//    public String error500(){
//        return "内部错误";
//    }
//
//    @RequestMapping("/404")
//    public String error404(){
//        return "对不起，您请求的页面找不到";
//    }
}
