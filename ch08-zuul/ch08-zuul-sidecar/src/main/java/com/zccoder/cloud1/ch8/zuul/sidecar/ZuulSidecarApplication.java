package com.zccoder.cloud1.ch8.zuul.sidecar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;

/**
 * @title 启动类
 * @describe 编写Sidecar微服务
 * @author zc
 * @version 1.0 2017-12-12
 */
@SpringBootApplication
@EnableSidecar
public class ZuulSidecarApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ZuulSidecarApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ZuulSidecarApplication.class);
	}
}