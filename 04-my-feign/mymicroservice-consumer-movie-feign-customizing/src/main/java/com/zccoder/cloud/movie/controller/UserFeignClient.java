package com.zccoder.cloud.movie.controller;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.zccoder.cloud.FeignConfiguration;
import com.zccoder.cloud.movie.domain.User;

import feign.Param;
import feign.RequestLine;

/**
 * @title Feign接口
 * @describe Feign接口
 * @author zc
 * @version 1.0 2017-12-05
 */
// @FeignClient注解中name值mymicroservice-provider-user是一个任意的客户端名称，用户创建Ribbon负载均衡器
// @FeignClient注解中configuration值指定配置类
@FeignClient(name = "mymicroservice-provider-user",configuration=FeignConfiguration.class)
public interface UserFeignClient {
	
	/***
	 * 使用feign自带的注解@RequestLine
	 */
	@RequestLine("GET /{id}")
	public User findById(@Param("id") Long id);
	
}
