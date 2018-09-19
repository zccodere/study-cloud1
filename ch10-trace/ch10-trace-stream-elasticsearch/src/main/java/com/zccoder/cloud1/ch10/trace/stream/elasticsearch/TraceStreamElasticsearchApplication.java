package com.zccoder.cloud1.ch10.trace.stream.elasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author zc
 * @version 1.0 2017-12-18
 * @title 将数据存储到elasticsearch
 * @describe 编写Zipkin Server
 */
@SpringBootApplication
@EnableZipkinStreamServer
public class TraceStreamElasticsearchApplication extends SpringBootServletInitializer {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(TraceStreamElasticsearchApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TraceStreamElasticsearchApplication.class);
    }
}