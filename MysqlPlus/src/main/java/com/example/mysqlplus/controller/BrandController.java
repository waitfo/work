package com.example.mysqlplus.controller;

import com.example.mysqlplus.aop.OperateLog;
import com.example.mysqlplus.entity.Brand;
import com.example.mysqlplus.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @RequestMapping("/insert")
    @OperateLog
    public Result insert(@RequestBody Brand brand){
        try {
            brandService.insert(brand);
            return new Result(true,"操作成功");
        }
    }

}
