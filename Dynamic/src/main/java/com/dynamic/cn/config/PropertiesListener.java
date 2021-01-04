package com.dynamic.cn.config;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

public class PropertiesListener implements ApplicationListener<ApplicationStartedEvent> {
    private String propertyFileName;
    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        PropertiesListenerConfig.loadAllProperties(propertyFileName);
    }

    public PropertiesListener(String propertyFileName){
        this.propertyFileName = propertyFileName;
    }
}
