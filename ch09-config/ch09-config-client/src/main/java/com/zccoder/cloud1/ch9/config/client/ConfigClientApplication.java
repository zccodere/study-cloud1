package com.zccoder.cloud1.ch9.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @title 启动类
 * @describe 编写Config Client
 * @author zc
 * @version 1.0 2017-12-14
 */
@SpringBootApplication
@RestController
public class ConfigClientApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ConfigClientApplication.class);
	}
	
	@Value("${profile}")
	private String profile;
	
	@GetMapping("/profile")
	public String hello(){
		return this.profile;
	}
}