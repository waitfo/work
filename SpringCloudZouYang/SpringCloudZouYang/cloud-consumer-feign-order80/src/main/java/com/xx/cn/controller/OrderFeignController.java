package com.xx.cn.controller;

import com.xx.cn.entities.CommonResult;
import com.xx.cn.entities.Payment;
import com.xx.cn.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value="/consumer/payment/feign/timeout")
    public String paymentFeignTimeout(){

        //openfeign-ribbon 客户端一般默认等待1s

        return paymentFeignService.paymentFeignTimeout();
    }
}
