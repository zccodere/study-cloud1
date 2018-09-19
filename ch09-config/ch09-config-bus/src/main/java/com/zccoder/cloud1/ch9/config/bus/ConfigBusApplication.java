package com.zccoder.cloud1.ch9.config.bus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RestController;

/**
 * @title 启动类
 * @describe Spring Cloud Bus实现自动刷新
 * @author zc
 * @version 1.0 2017-12-14
 */
@SpringBootApplication
@RestController
public class ConfigBusApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ConfigBusApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ConfigBusApplication.class);
	}
}