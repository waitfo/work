package com.dynamic.cn.controller;

import com.dynamic.cn.config.BootProperties;
import com.dynamic.cn.config.PropertiesListenerConfig;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping(value = "/test")
    public BootProperties test(){
        BootProperties properties = new BootProperties();
        properties.setKey(PropertiesListenerConfig.getProperty("a.b.c"));
        String expirateTime = PropertiesListenerConfig.getProperty("a.b.t");
        Long time = expirateTime==null?0L:Long.valueOf(expirateTime);
        properties.setExpriateTime(time);
        return properties;
    }
}
