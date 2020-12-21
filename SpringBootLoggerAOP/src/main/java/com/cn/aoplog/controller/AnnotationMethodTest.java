package com.cn.aoplog.controller;

import com.cn.aoplog.annotations.AnnotationMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnnotationMethodTest {
    @RequestMapping("/annotationMethodTest")
    @AnnotationMethod(name = "test2")
    public String annotationMethodTest(int id,String name){
        System.out.println("使用AOP方式打印日志");
        return "SUCCESS";
    }
}
