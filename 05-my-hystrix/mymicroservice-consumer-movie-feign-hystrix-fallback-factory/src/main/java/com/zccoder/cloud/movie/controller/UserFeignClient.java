package com.zccoder.cloud.movie.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zccoder.cloud.movie.domain.User;

import feign.hystrix.FallbackFactory;

/**
 * @title Feign接口
 * @describe Feign接口
 * @author zc
 * @version 1.0 2017-12-06
 */
// @FeignClient注解中name值mymicroservice-provider-user是一个任意的客户端名称，用户创建Ribbon负载均衡器
@FeignClient(name = "mymicroservice-provider-user",fallbackFactory=FeignClientFallbackFactory.class)
public interface UserFeignClient {
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public User findById(@PathVariable("id") Long id);
	
}

/**
 * @title 实现FallbackFactory接口，并重写create方法
 * @describe 实现FallbackFactory接口，并重写create方法
 * @author zc
 * @version 1.0 2017-12-06
 */
@Component
class FeignClientFallbackFactory implements FallbackFactory<UserFeignClient> {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FeignClientFallbackFactory.class);
	
	@Override
	public UserFeignClient create(Throwable cause) {
		// 使用匿名内部类方式
		return new UserFeignClient(){
			@Override
			public User findById(Long id) {
				// 日志最好放在各个fallback方法中
				FeignClientFallbackFactory.LOGGER.info("fallback reason was [{}]",cause);
				
				User user = new User();
				user.setId(-1L);
				user.setName("默认用户");
				return user;
			}
		};
	}
}