package com.demo.cn.facorybean;

import com.demo.cn.User;
import org.springframework.beans.factory.FactoryBean;

public class MyBean implements FactoryBean<User> {

    //定义返回bean
    @Override
    public User getObject() throws Exception {
        User user = new User();
        user.add();
        return user;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
