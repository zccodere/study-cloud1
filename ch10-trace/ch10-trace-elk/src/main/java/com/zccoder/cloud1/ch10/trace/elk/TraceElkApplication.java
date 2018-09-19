package com.zccoder.cloud1.ch10.trace.elk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @author zc
 * @version 1.0 2017-12-18
 * @title 启动类
 * @describe Spring Cloud Sleuth与ELK配合使用
 */
@SpringBootApplication
public class TraceElkApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(TraceElkApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TraceElkApplication.class);
    }
}