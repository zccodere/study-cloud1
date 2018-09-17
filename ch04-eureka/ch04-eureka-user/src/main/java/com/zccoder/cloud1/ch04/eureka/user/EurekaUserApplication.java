package com.zccoder.cloud1.ch04.eureka.user;

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
public class EurekaUserApplication extends SpringBootServletInitializer
{
    public static void main( String[] args )
    {
        SpringApplication.run(EurekaUserApplication.class, args);
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(EurekaUserApplication.class);
    }
}