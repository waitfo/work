package com.example.springboottest;

import com.example.springboottest.dao.UserDo;
import com.example.springboottest.entiy.UserJPA;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringboottestApplicationTests {

    @Autowired
    private UserDo userDo;

    @Before("")
    public void before() {
        UserJPA userDO = new UserJPA();
        userDO.setId(1);
        userDO.setName("风清扬");
        userDO.setEmail("fengqy");
        userDO.setMobile("123456");
        userDo.save(userDO);
        UserJPA userDO2= new UserJPA();
        userDO2.setId(3);
        userDO2.setName("东方不败");
        userDO2.setEmail("bubai");
        userDO2.setMobile("123456");
        userDo.save(userDO2);
        userDO2.setId(5);
        userDO2.setName("向问天");
        userDO2.setEmail("wentian");
        userDO2.setMobile("123456");
        userDo.save(userDO2);
    }
    @Test
    public void testAdd() {
        UserJPA userDO = new UserJPA();
        userDO.setId(2);
        userDO.setName("任我行");
        userDO.setEmail("renwox@qq.com");
        userDO.setMobile("123456");
        userDo.save(userDO);
        UserJPA userDO1 = new UserJPA();
        userDO1.setId(4);
        userDO1.setName("令狐冲");
        userDO1.setEmail("linghucf@qq.com");
        userDO1.setMobile("123456");
        userDo.save(userDO1);
    }

    @After("")
    public void after() {
        userDo.deleteById(1);
        userDo.deleteById(3);
        userDo.deleteById(5);
    }

}
