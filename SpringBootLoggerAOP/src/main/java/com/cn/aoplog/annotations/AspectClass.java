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
    @Pointcut("@within(com.cn.aoplog.annotations.AnnotationClass)")
    public void testClassLog(){
    }

//    @Before(value = "testClassLog()")
//    public void doBefore(JoinPoint joinPoint){
//        logger.info("基于类的切面日志");
//        logger.error("这是一个错误日志");
//        System.out.println("基于类");
//    }

    @Before(value = "testClassLog()")
    public void doBefore(JoinPoint joinPoint){
        logger.info("基于类的切面日志");
        logger.error("这是一个错误日志");
        System.out.println("基于类before");
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)requestAttributes;
        HttpServletRequest httpServletRequest = servletRequestAttributes.getRequest();

        Map<String,Object> map = new HashMap<>();
        logger.info("URL"+ httpServletRequest.getRequestURL());
        map.put("url",httpServletRequest.getRequestURL());
        logger.info("URI"+ httpServletRequest.getRequestURI());
        map.put("uri",httpServletRequest.getRequestURI());
        logger.info("HTTP_METHOD"+httpServletRequest.getMethod());
        map.put("http_method",httpServletRequest.getMethod());
        logger.info("REMOTE_ADDR"+httpServletRequest.getRemoteAddr());
        map.put("remote_addr",httpServletRequest.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "."
                + joinPoint.getSignature().getName());
        map.put("classMethod",
                joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
        map.put("args", Arrays.toString(joinPoint.getArgs()));
        logger.info("USER_AGENT"+httpServletRequest.getHeader("User-Agent"));
        map.put("userAgent", httpServletRequest.getHeader("User-Agent"));
//        logger.info("执行方法：" + annotationClass.name());
//        map.put("methodName", annotationClass.name());
        threadLocal.set(map);
    }


    @AfterReturning(value = "testClassLog()", returning = "ret")
    public void doAfterReturning(Object ret) throws Throwable {
        logger.info("基于类的切面日志");
        logger.error("这是一个错误日志");
        System.out.println("基于类after");
        Map<String, Object> threadInfo = threadLocal.get();
        threadInfo.put("result", ret);
//        if (controllerWebLog.intoDb()) {
//            //插入数据库操作
//            //insertResult(threadInfo);
//        }
//        logger.info("DESC:"+annotationClass.description());
        // 处理完请求，返回内容
        logger.info("RESPONSE : " + ret);
    }

    @AfterThrowing(value = "testClassLog()", throwing = "throwable")
    public void doAfterThrowing(Throwable throwable) {
        logger.info("基于类的切面日志");
        logger.error("这是一个错误日志");
        System.out.println("基于类throw");
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();

        ServletRequestAttributes sra = (ServletRequestAttributes) ra;

        HttpServletRequest request = sra.getRequest();
        // 异常信息
        logger.error("{}接口调用异常，异常信息{}", request.getRequestURI(), throwable);
    }

}
