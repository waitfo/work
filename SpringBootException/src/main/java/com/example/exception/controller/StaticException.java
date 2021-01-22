package com.example.exception.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StaticException {

    @GetMapping(value = "/staticTest500")
    public String staticTest(){
        int a =10/0;

        return "exception";
    }

    @RequestMapping("/json")
    public void json(ModelMap modelMap){
        System.out.println(modelMap.get("author"));
        int i=5/0;
    }
}
