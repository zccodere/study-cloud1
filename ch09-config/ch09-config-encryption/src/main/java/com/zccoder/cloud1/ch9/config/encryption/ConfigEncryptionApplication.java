package com.zccoder.cloud1.ch9.config.encryption;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @title 启动类
 * @describe 配置内容对称加密
 * @author zc
 * @version 1.0 2017-12-14
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigEncryptionApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ConfigEncryptionApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ConfigEncryptionApplication.class);
	}
}