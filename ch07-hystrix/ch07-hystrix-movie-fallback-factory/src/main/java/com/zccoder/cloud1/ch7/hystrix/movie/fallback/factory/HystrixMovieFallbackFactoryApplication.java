package com.zccoder.cloud1.ch7.hystrix.movie.fallback.factory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @title 启动类
 * @describe 通过Fallback Factory检查回退原因
 * @author zc
 * @version 1.0 2017-12-06
 */
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class HystrixMovieFallbackFactoryApplication extends SpringBootServletInitializer
{
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
    public static void main( String[] args )
    {
        SpringApplication.run(HystrixMovieFallbackFactoryApplication.class, args);
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(HystrixMovieFallbackFactoryApplication.class);
    }
}