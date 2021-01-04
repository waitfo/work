package com.dynamic.cn;

import com.dynamic.cn.config.PropertiesListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DynamicApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(DynamicApplication.class);
        application.addListeners(new PropertiesListener("application.properties"));
        application.run(args);
    }

}
