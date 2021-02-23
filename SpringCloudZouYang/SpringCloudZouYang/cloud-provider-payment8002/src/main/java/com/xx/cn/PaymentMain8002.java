package com.xx.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PaymentMain8002 {


    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(PaymentMain8002.class,args);
    }
}
