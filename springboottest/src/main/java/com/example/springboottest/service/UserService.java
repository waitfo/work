package com.example.springboottest.service;

import com.example.springboottest.entiy.UserJPA;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserJPA> listAllUser() ;
    Optional<UserJPA> getUser(int id) ;
    UserJPA createUser(UserJPA user) ;
    void deleteUser(int id) ;
}
