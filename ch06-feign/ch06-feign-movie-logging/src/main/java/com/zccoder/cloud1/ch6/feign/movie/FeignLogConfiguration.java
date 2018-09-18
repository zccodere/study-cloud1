package com.zccoder.cloud1.ch6.feign.movie;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;

/**
 * @title 配置类
 * @describe Feign配置类
 * @author zc
 * @version 1.0 2017-12-05
 */
@Configuration
public class FeignLogConfiguration {
	
	@Bean
	Logger.Level feignLoggerLevel(){
		return Logger.Level.FULL;
	}
	
}
