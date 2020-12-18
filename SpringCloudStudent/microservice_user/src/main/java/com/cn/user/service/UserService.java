package com.cn.user.service;

import com.cn.user.dao.UserDao;
import com.cn.user.entiy.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 查询所有用户
     */
    public List<User> findAll(){
        return userDao.findAll();
    }

    public User findById(Integer id){
        return userDao.findById(id).get();
    }

    public void add(User user){
        userDao.save(user);
    }

    public void update(User user){//user对象必须有数据库存在的id值，如果没有就insert
        userDao.save(user);
    }

    public void deleteById(Integer id){
        userDao.deleteById(id);
    }
}
