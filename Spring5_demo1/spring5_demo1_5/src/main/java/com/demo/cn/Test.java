package com.demo.cn;

import com.demo.cn.cofig.TxConfig;
import com.demo.cn.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;

public class Test {

    @org.junit.Test
    public void test1(){


        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean1.xml");

        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();
    }
    @org.junit.Test
    public void test2(){


        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean2.xml");

        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();
    }

    @org.junit.Test
    public void test3(){


        ApplicationContext context =
                new AnnotationConfigApplicationContext(TxConfig.class);

        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();
    }
}
