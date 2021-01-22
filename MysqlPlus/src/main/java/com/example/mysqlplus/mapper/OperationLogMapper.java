package com.example.mysqlplus.mapper;

import com.example.mysqlplus.entity.OperationLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OperationLogMapper{
    int insert(OperationLog operationLog);
}
