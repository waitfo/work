package com.example.mysqlplus.service;

import com.example.mysqlplus.entity.OperationLog;
import com.example.mysqlplus.mapper.OperationLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationLogService {

    @Autowired
    OperationLogMapper operationLogMapper;
    public int insert(OperationLog operationLog){
        return operationLogMapper.insert(operationLog);
    }
}
