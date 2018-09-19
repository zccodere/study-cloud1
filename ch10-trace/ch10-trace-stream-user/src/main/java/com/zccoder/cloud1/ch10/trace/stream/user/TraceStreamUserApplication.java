package com.zccoder.cloud1.ch10.trace.stream.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @author zc
 * @version 1.0 2017-12-18
 * @title 使用消息中间件收集数据
 * @describe 改造微服务
 */
@SpringBootApplication
public class TraceStreamUserApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(TraceStreamUserApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TraceStreamUserApplication.class);
    }
}