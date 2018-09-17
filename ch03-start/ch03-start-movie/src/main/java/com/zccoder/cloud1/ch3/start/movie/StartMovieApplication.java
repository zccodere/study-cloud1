package com.zccoder.cloud1.ch3.start.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 项目启动类
 * @author ZhangCheng on 2017-07-17 13:36
 *
 */
@SpringBootApplication
public class StartMovieApplication extends SpringBootServletInitializer
{
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
    public static void main( String[] args )
    {
        SpringApplication.run(StartMovieApplication.class, args);
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(StartMovieApplication.class);
    }
}