package com.example.cn.controller;

import javafx.scene.input.DataFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("/test1")
    public String test1(){
        logger.debug("{}这是一个debug级别的日志{}", new DataFormat(String.valueOf(System.currentTimeMillis())),"debug");
        logger.info("hello");
        return "hello world";
    }
}
