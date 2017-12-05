package com.zccoder.cloud.movie.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zccoder.cloud.movie.domain.User;

/**
 * @title Feign接口
 * @describe Feign接口
 * @author zc
 * @version 1.0 2017-12-05
 */
public interface UserFeignClient {
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public User findById(@PathVariable("id") Long id);
	
}
