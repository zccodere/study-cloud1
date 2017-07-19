package com.zccoder.cloud.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 项目启动类
 * @author ZhangCheng on 2017-07-18 13:21
 *
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