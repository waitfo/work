package com.cn.aoplog.controller;

import com.cn.aoplog.annotations.AnnotationClass;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AnnotationClass(name = "testClass")
public class AnnotationClassTest implements ControllerAopInterface {
    @RequestMapping("/annotationClassTest")
    public String annotationMethodTest(){
        System.out.println("使用AOP方式打印日志,基于类");
        return "SUCCESS";
    }
}
