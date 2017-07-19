package com.zccoder.cloud.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.zccoder.cloud.user.entity.User;
import com.zccoder.cloud.user.repository.UserRepository;

/**
 * 用户控制类
 * @author ZhangCheng on 2017-07-19 12:54
 *
 */
@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/{id}")
	public User findById(@PathVariable Long id){
		User findOne = userRepository.findOne(id);
		return findOne;
	}
}
