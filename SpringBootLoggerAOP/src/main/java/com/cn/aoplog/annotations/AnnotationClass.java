package com.cn.aoplog.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)// 定义你的注解可以应用在哪里（例如是方法还是字段）
@Retention(RetentionPolicy.RUNTIME)//定义了注解在哪里可用，在源代码中（SOURCE），class文件（CLASS）中或者是在运行时（RUNTIME）
public @interface AnnotationClass {
    String name();
    String description() default "This is annotation Class description";
}
