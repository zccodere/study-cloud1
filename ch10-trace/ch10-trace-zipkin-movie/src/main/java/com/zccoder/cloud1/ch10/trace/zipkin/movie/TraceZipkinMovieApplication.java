package com.zccoder.cloud1.ch10.trace.zipkin.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author zc
 * @version 1.0 2017-12-18
 * @title 启动类
 * @describe 微服务整合Zipkin
 */
@SpringBootApplication
public class TraceZipkinMovieApplication extends SpringBootServletInitializer {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(TraceZipkinMovieApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TraceZipkinMovieApplication.class);
    }
}