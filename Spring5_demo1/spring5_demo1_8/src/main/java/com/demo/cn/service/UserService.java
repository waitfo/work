package com.demo.cn.service;

import com.demo.cn.entity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

    //根据id查询用户
    Mono<User> getUserById(int id);

    //查询所有的用户
    Flux<User> getAllUser();

    //添加用户
    Mono<Void> saveUserInfo(Mono<User> user);
}
