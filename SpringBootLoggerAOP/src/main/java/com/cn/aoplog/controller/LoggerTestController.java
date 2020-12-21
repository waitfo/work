package com.cn.aoplog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;

@RestController
public class LoggerTestController {
    final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("/test1")
    public String test1(){
        logger.info("这是一个info日志{}", new SimpleDateFormat().format(System.currentTimeMillis()));
        logger.debug("这是一个debug日志{}", new SimpleDateFormat().format(System.currentTimeMillis()));
        logger.error("这是一个error日志{}","ERROR");
        logger.warn("这是一个warn日志{}","WARNNING");
        System.out.println("打印日志");
        return "SUCCESS";
    }

}
