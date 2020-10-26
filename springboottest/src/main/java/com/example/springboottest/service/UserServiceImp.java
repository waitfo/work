package com.example.springboottest.service;

import com.example.springboottest.dao.UserDo;
import com.example.springboottest.entiy.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

//    @Autowired
//    private UserDao userDao;
    @Autowired
    private UserDo userDao;

    public List<UserJPA> listAllUser() {
        List<UserJPA> list = userDao.findAll();
        return list;
    }

    public Optional<UserJPA> getUser(int id) {
        Optional<UserJPA> user = userDao.findById(id);
        return user;
    }

    public UserJPA createUser(UserJPA user) {
        UserJPA save = userDao.save(user);
        return save;
    }

    public void deleteUser(int id) {
        userDao.deleteById(id);
    }
}
