package com.cn.user.controller;

import com.cn.user.entiy.User;
import com.cn.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户Controller
 */
@RequestMapping("/user")
@RestController     //@RestController = @RequestMapping+@ResponseBody
@Api(description = "用户控制器")
public class UserController {

    @Autowired
    UserService userService;
    /**
     * 查询所有用户
     */
    @ApiOperation(value="查询所有用户")
    @RequestMapping(method = RequestMethod.GET)
    public List<User> findAll(){
        return userService.findAll();
    }

    @ApiOperation(value="查询用户by id")
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User findById(@PathVariable Integer id){
        System.out.println("222");
        return userService.findById(id);
    }

    @ApiOperation(value="添加用户")
    @RequestMapping(method = RequestMethod.POST)
    public String add(@RequestBody User user){//@RequestBody将json对象转成User
        userService.add(user);
        return "添加成功";
    }

    @ApiOperation(value="修改用户")
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public String update(@RequestBody User user,@PathVariable Integer id){
        user.setId(id);
        userService.update(user);
        return "修改成功";
    }

    @ApiOperation(value="删除用户")
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public String deleteById(Integer id){
        userService.deleteById(id);
        return "删除成功";
    }
}
