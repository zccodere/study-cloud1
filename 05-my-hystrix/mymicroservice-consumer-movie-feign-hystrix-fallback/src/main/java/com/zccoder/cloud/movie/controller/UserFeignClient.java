package com.zccoder.cloud.movie.controller;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zccoder.cloud.movie.domain.User;

/**
 * @title Feign的fallback测试
 * @describe 使用@FeignClient的fallback属性指定回退类
 * @author zc
 * @version 1.0 2017-12-06
 */
// @FeignClient注解中name值mymicroservice-provider-user是一个任意的客户端名称，用户创建Ribbon负载均衡器
@FeignClient(name = "mymicroservice-provider-user", fallback=FeignClientFallback.class)
public interface UserFeignClient {
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public User findById(@PathVariable("id") Long id);
	
}

/**
 * @title 回退类FeignClientFallback需实现Feign Client接口
 * @describe FeignClientFallback也可以是public class，没有区别
 * @author zc
 * @version 1.0 2017-12-06
 */
@Component
class FeignClientFallback implements UserFeignClient {

	@Override
	public User findById(Long id) {
		User user = new User();
		user.setId(-1L);
		user.setName("默认用户");
		return user;
	}
	
}