package com.xx.cn.controller;

import com.xx.cn.bean.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

    @Autowired
    private Car car;

    @RequestMapping("/car")
    public String testCar(){
        return car.toString();
    }
}
