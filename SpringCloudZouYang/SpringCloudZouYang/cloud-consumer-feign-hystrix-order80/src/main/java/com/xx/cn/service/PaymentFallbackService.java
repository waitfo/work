package com.xx.cn.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String apymentInfo_OK(Integer id) {
        return "----PaymentFallbackservice-ok fall back";
    }

    @Override
    public String apymentInfo_TimeOut(Integer id) {
        return "----PaymentFallbackservice-timeout fall back";

    }
}
