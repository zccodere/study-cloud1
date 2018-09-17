package com.zccoder.cloud1.ch5.ribbon.movie.customizing.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

/**
 * @title 测试自定义配置
 * @describe 使用@RibbonClient ，为特定name的 Ribbon Client自定义配置
 * 使用@RibbonClient的configuration属性指定Ribbon的配置类
 * @author zc
 * @version 1.0 2017-12-04
 */
@Configuration
@RibbonClient(name="mymicroservice-provider-user",configuration=RibbonConfiguration.class)
public class TestConfiguration {
	
	
}
