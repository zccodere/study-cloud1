package com.zccoder.cloud1.ch5.ribbon.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author zc
 * @version 1.0 2017-12-04
 * @title 启动类
 * @describe 为服务消费者整合Ribbon
 */
@EnableDiscoveryClient
@SpringBootApplication
public class RibbonMovieApplication extends SpringBootServletInitializer {

    /**
     * // 添加 @LoadBalanced 注解，为 RestTemplate 整合 Ribbon，使其具备负责均衡的能力
     *
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(RibbonMovieApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(RibbonMovieApplication.class);
    }
}