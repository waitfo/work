package com.example.mysqlplus;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.example.mysqlplus.mapper")
public class MysqlplusApplication {

    public static void main(String[] args) {
        SpringApplication.run(MysqlplusApplication.class, args);
    }

}
