package com.zccoder.cloud1.ch9.config.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @title 启动类
 * @describe 编写Config Server
 * @author zc
 * @version 1.0 2017-12-14
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigAuthApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ConfigAuthApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ConfigAuthApplication.class);
	}
}