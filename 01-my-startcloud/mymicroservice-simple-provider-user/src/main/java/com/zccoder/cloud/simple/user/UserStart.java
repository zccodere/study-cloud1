package com.zccoder.cloud.simple.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 项目启动类
 * @author ZhangCheng on 2017-07-17 13:17
 *
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