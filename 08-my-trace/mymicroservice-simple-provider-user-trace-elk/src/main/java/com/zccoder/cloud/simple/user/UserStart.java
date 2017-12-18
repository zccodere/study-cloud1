package com.zccoder.cloud.simple.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @title 启动类
 * @describe Spring Cloud Sleuth与ELK配合使用
 * @author zc
 * @version 1.0 2017-12-18
 */
@SpringBootApplication
public class UserStart extends SpringBootServletInitializer
{
    public static void main( String[] args )
    {
        SpringApplication.run(UserStart.class, args);
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(UserStart.class);
    }
}