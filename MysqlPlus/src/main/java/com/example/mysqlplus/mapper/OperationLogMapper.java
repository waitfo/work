package com.example.mysqlplus.mapper;

import com.example.mysqlplus.entity.OperationLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface OperationLogMapper{

    int insert(OperationLog operationLog);

    /**
     * 查询日志
     * paraMap是查询条件 start是分页查询的时候的起始位置，rows是每页的个数
     * @param paramMap
     * @return
     */
    List<OperationLog> select(Map paramMap);

    /**
     * 统计符合查询条件的日志的个数，用来做分页查询
     * @param paramMap
     * @return
     */
    Long countByCondition(Map paramMap);
}
