package com.example.mysqlplus.service;

import com.example.mysqlplus.entity.OperationLog;
import com.example.mysqlplus.entity.PageResult;
import com.example.mysqlplus.mapper.OperationLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OperationLogService {

    @Autowired
    OperationLogMapper operationLogMapper;
    public int insert(OperationLog operationLog){
        return operationLogMapper.insert(operationLog);
    }

    public PageResult findByPage(Map paramMap, Integer pageNum, Integer rows){

        if(paramMap==null){
            paramMap = new HashMap();
        }
        paramMap.put("start",(pageNum-1)*rows);
        paramMap.put("rows",rows);

        Object costTime = paramMap.get("costTime");
        if(costTime!=null){
            if("".equals(costTime.toString())){
                paramMap.put("costTime",null);
            }else {
                paramMap.put("costTime",new Long(costTime.toString()));
            }
        }

        Long startTime = System.currentTimeMillis();

        Long count = operationLogMapper.countByCondition(paramMap);

        Long endTime = System.currentTimeMillis();
        System.out.println("Count Cost Time"+(endTime-startTime));

        List<OperationLog> list = operationLogMapper.select(paramMap);

        Long endTime2 = System.currentTimeMillis();
        System.out.println("ListLog Cost Time"+(endTime2-endTime));

        return new PageResult(count,list);
    }

}
