package com.example.mysqlplus.aop;


import com.example.mysqlplus.entity.OperationLog;
import com.example.mysqlplus.service.OperationLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Component
@Aspect
public class OperateAdvice {

    private static Logger logger = Logger.getLogger(OperateAdvice.class);

    @Autowired
    private OperationLogService operationLogService;


    @Around("execution(* com.example.mysqlplus.controller.*.*(..)) && @annotation(operateLog)")
    public Object insertLogAround(ProceedingJoinPoint pjp,OperateLog operateLog) throws Throwable{

        System.out.println("********************* 记录日志 [start] *********************");

        OperationLog operationLog = new OperationLog();

        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        operationLog.setOperateTime(sdf.format(new Date()));
        operationLog.setOperateUser("");//todo 待加入

        operationLog.setOperateClass(pjp.getTarget().getClass().getName());
        operationLog.setOperateMethod(pjp.getSignature().getName());

        Object[] args = pjp.getArgs();
        operationLog.setParamAndValue(Arrays.toString(args));

        long startTime = System.currentTimeMillis();

        //放行
        Object object = pjp.proceed();

        long endTime = System.currentTimeMillis();
        operationLog.setCostTime(endTime-startTime);

        if(object!=null){
            operationLog.setReturnClass(object.getClass().getName());
            operationLog.setReturnValue(object.toString());
        }else{
            operationLog.setReturnClass("java.lang.Object");
            operationLog.setReturnValue("void");
        }

        //logger.error(JsonUtils.obj2JsonString(op)); todo 待实现

        operationLogService.insert(operationLog); //todo 待实现

        System.out.println("********************* 记录日志 [end] *********************");

        return object;
    }
}
