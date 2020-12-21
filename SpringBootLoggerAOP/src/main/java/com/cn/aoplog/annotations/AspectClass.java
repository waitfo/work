package com.cn.aoplog.annotations;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
@Order(100)
public class AspectClass {
    private final static Logger logger = LoggerFactory.getLogger(AspectClass.class);
    private ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<Map<String,Object>>();
    // 横切点
    // 匹配实现ControllerAopInterface接口的目标对象
    @Pointcut("target(com.cn.aoplog.controller.ControllerAopInterface)")
    public void testClassLog(){
    }

    @Before(value = "testClassLog()&&@annotation(annotationClass)")
    public void doBefore(JoinPoint joinPoint,AnnotationMethod annotationClass){

    }

}
