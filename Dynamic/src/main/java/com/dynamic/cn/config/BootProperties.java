package com.dynamic.cn.config;

import org.springframework.stereotype.Component;

@Component
public class BootProperties {
    private String key;
    private long expriateTime;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public long getExpriateTime() {
        return expriateTime;
    }

    public void setExpriateTime(long expriateTime) {
        this.expriateTime = expriateTime;
    }
}
