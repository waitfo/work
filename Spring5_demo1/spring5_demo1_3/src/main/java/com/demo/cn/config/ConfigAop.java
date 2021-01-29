package com.demo.cn.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"com.demo"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ConfigAop {
}
