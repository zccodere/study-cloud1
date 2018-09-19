package com.zccoder.cloud1.ch10.trace.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @title 启动类
 * @describe 整合Spring Cloud Sleuth
 * @author zc
 * @version 1.0 2017-12-18
 */
@SpringBootApplication
public class TraceMovieApplication extends SpringBootServletInitializer
{
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
    public static void main( String[] args )
    {
        SpringApplication.run(TraceMovieApplication.class, args);
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TraceMovieApplication.class);
    }
}