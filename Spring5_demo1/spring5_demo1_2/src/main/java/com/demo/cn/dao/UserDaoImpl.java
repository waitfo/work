package com.demo.cn.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{
    public void add(){
        System.out.println("自动注入");
    }
}
