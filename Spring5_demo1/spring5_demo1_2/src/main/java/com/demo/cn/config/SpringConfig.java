package com.demo.cn.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration //作为配置类，替代xml配置文件
@ComponentScan(basePackages = {"com.demo.cn"})
public class SpringConfig {

}
