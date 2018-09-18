package com.zccoder.cloud1.ch6.feign.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author zc
 * @version 1.0 2017-12-05
 * @title 启动类
 * @describe 为服务消费者整合Feign
 */
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class FeignMovieApplication extends SpringBootServletInitializer {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(FeignMovieApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(FeignMovieApplication.class);
    }
}