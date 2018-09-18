package com.zccoder.cloud1.ch6.feign.movie.controller;

import com.zccoder.cloud1.ch6.feign.movie.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @title 电影控制类
 * @describe 电影控制类
 * @author zc
 * @version 1.0 2017-12-05
 */
@RestController
public class MovieController {
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	@GetMapping("/user/{id}")
	public User findById(@PathVariable Long id){
		// 使用Feign去调用用户微服务API
		return this.userFeignClient.findById(id);
	}
}
