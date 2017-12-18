package com.zccoder.cloud.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import zipkin.server.EnableZipkinServer;

/**
 * @title Spring Cloud Sleuth与Zipkin配合使用
 * @describe 编写Zipkin Server
 * @author zc
 * @version 1.0 2017-12-18
 */
@SpringBootApplication
@EnableZipkinServer
public class ServerStart extends SpringBootServletInitializer
{
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
    public static void main( String[] args )
    {
        SpringApplication.run(ServerStart.class, args);
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ServerStart.class);
    }
}