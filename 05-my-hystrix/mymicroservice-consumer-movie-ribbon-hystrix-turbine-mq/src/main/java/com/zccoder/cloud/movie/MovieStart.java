package com.zccoder.cloud.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @title 启动类
 * @describe 通用方式整合Hystrix
 * @author zc
 * @version 1.0 2017-12-06
 */
@EnableDiscoveryClient
@EnableHystrix
@SpringBootApplication
public class MovieStart extends SpringBootServletInitializer {

	@Bean
	// 添加 @LoadBalanced 注解，为 RestTemplate 整合 Ribbon，使其具备负责均衡的能力
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(MovieStart.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MovieStart.class);
	}
}