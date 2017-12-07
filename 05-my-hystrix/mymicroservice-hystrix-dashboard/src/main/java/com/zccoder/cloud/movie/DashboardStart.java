package com.zccoder.cloud.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @title 启动类
 * @describe 使用Hystrix Dashboard可视化监控数据
 * @author zc
 * @version 1.0 2017-12-07
 */
@EnableHystrixDashboard
@SpringBootApplication
public class DashboardStart extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(DashboardStart.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DashboardStart.class);
	}
}