package com.example.springboottest.controller;

import com.example.springboottest.entiy.UserJPA;
import com.example.springboottest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    //id为路径，按id获取用户信息
    @RequestMapping("/list/{id}")
    public Optional<UserJPA> test(@PathVariable(name = "id") int id){

        System.out.println(id);
        return userService.getUser(id);
    }

    @RequestMapping("/get")
    public Optional<UserJPA> getUserById(int id){
        return userService.getUser(id);
    }

    @RequestMapping("/list")
    public List<UserJPA> listTest(){
        return userService.listAllUser();
    }

    @RequestMapping("/add")
    public UserJPA add(UserJPA test){
        return userService.createUser(test);
    }

    @RequestMapping("/delete")
    public void delete(int id){
        userService.deleteUser(id);
    }

    @RequestMapping("/delete/{id}")
    public void deleteById(@PathVariable(name = "id") int id){
        userService.deleteUser(id);
    }
}
