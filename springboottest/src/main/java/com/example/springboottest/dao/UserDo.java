package com.example.springboottest.dao;

import com.example.springboottest.entiy.UserJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDo extends JpaRepository<UserJPA, Integer> {
}