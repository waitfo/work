package com.example.mysqlplus.controller;

import com.example.mysqlplus.aop.OperateLog;
import com.example.mysqlplus.entity.PageResult;
import com.example.mysqlplus.service.OperationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/operationLog")
public class OperationLogController {

    @Autowired
    OperationLogService operationLogService;

    @RequestMapping("/findByPage")
    @OperateLog
    public PageResult findByPage(@RequestBody Map paramMap,Integer pageNum,Integer rows){
        return operationLogService.findByPage(paramMap,pageNum,rows);
    }
}
