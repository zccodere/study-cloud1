package com.zccoder.cloud1.ch7.hystrix.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @author zc
 * @version 1.0 2017-12-07
 * @title 启动类
 * @describe 使用Turbine监控多个微服务
 */
@EnableTurbine
@SpringBootApplication
public class HystrixTurbineApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(HystrixTurbineApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(HystrixTurbineApplication.class);
    }
}