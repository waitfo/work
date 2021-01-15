package com.example.exception.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//如果使用RestController注解，无法找到.html因为返回的是json
@Controller
public class MyExceptionStaticAndDy {

    @GetMapping("/testStatic")
    public String testStatic(){
        System.out.println("静态500错误！");
        int i = 10/0;
        return "";
    }
}
