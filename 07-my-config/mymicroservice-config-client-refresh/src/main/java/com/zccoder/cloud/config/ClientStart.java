package com.zccoder.cloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RestController;

/**
 * @title 启动类
 * @describe 编写Config Client
 * @author zc
 * @version 1.0 2017-12-14
 */
@SpringBootApplication
@RestController
public class ClientStart extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ClientStart.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ClientStart.class);
	}
}