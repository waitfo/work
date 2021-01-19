package com.example.exception.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StaticException {

    @GetMapping(value = "/staticTest500")
    public String staticTest(){
        int a =10/0;

        return "exception";
    }
}
