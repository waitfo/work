package com.cn.user.controller;

import com.cn.user.entiy.User;
import com.cn.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户Controller
 */
@RequestMapping("/user")
@RestController     //@RestController = @RequestMapping+@ResponseBody
public class UserController {

    @Autowired
    UserService userService;
    /**
     * 查询所有用户
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<User> findAll(){
        return userService.findAll();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User findById(@PathVariable Integer id){
        System.out.println("222");
        return userService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public String add(@RequestBody User user){//@RequestBody将json对象转成User
        userService.add(user);
        return "添加成功";
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public String update(@RequestBody User user,@PathVariable Integer id){
        user.setId(id);
        userService.update(user);
        return "修改成功";
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public String deleteById(Integer id){
        userService.deleteById(id);
        return "删除成功";
    }
}
