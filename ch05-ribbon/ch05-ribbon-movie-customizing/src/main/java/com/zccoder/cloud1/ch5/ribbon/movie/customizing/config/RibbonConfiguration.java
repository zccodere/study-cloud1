package com.zccoder.cloud1.ch5.ribbon.movie.customizing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

/**
 * @title 该类为Ribbon的配置类
 * @describe 注意：该类不应该在主应用程序上下文的@ComponentScan中
 * @author zc
 * @version 1.0 2017-12-04
 */
@Configuration
public class RibbonConfiguration {
	
	@Bean
	public IRule ribbonRule(){
		// 负载均衡规则，改为随机
		return new RandomRule();
	}
	
}
