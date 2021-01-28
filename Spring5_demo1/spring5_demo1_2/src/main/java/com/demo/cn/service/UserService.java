package com.demo.cn.service;

import com.demo.cn.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//在注解里面value属性值可以省略不写
//默认值是类名称首字母小写
@Service(value="userService")//<bean id="userService" class="...+>
public class UserService {

    @Autowired
    private UserDao userDao;

    public void add(){
        userDao.add();
        System.out.println("service add...");
    }
}
