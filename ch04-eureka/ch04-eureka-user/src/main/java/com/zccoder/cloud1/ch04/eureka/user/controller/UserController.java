package com.zccoder.cloud1.ch04.eureka.user.controller;

import com.zccoder.cloud1.ch04.eureka.user.entity.User;
import com.zccoder.cloud1.ch04.eureka.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制类
 * @author ZhangCheng on 2017-07-18 13:21
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
