package com.zccoder.cloud.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 项目启动类
 * @author ZhangCheng on 2017-07-18 13:26
 *
 */
@EnableDiscoveryClient
@SpringBootApplication
public class MovieStart extends SpringBootServletInitializer
{
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
    public static void main( String[] args )
    {
        SpringApplication.run(MovieStart.class, args);
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MovieStart.class);
    }
}