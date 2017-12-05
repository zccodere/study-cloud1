package com.zccoder.cloud.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @title 启动类
 * @describe 手动创建Feign
 * @author zc
 * @version 1.0 2017-12-05
 */
@EnableDiscoveryClient
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