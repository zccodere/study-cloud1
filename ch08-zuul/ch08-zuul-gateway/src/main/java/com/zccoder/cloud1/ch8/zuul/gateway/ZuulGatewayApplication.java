package com.zccoder.cloud1.ch8.zuul.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @title 启动类
 * @describe 编写Zuul过滤器
 * @author zc
 * @version 1.0 2017-12-11
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulGatewayApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ZuulGatewayApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ZuulGatewayApplication.class);
	}
}