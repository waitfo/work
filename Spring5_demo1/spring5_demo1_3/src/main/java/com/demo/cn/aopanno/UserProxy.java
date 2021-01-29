package com.demo.cn.aopanno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

//增强类
@Component
@Aspect
public class UserProxy {

    //相同切入点抽取
    @Pointcut(value = "execution(* com.demo.cn.aopanno.User.add(..))")
    public void pointdemo(){}

    //前置通知
    @Before(value = "pointdemo()")
    public void before(){
        System.out.println("before....");
    }

    @AfterReturning(value = "execution(* com.demo.cn.aopanno.User.add(..))")
    public void afterReturning(){
        System.out.println("afterReturning");
    }

    @After(value = "execution(* com.demo.cn.aopanno.User.add(..))")
    public void after(){
        System.out.println("after");
    }

    @AfterThrowing(value = "execution(* com.demo.cn.aopanno.User.add(..))")
    public void afterThrowing(){
        System.out.println("afterThrowing");
    }

    @Around(value = "execution(* com.demo.cn.aopanno.User.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕之前");
        proceedingJoinPoint.proceed();
        System.out.println("环绕之后");
    }
}
