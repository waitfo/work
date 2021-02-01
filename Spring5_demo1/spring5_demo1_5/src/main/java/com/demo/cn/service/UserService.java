package com.demo.cn.service;

import com.demo.cn.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.SERIALIZABLE)
public class UserService {

    @Autowired
    private UserDao userDao;

    //转账的方法
    public void accountMoney(){
//        //第一步 开启事务
//
//        //第二步 进行业务操作
//
//        try {
//            //lucy少100
            userDao.reduceMoney();
//
//            //模拟异常
            int i = 10 / 0;
//
//            //mary多100
           userDao.addMoney();
//
//            //第三步 没有发生异常，提交事务
//        }catch (Exception e){
//            //第四步 出现异常，事务回滚
//        }
    }

}
