package com.zccoder.cloud1.ch10.trace.stream.user.controller;

import com.zccoder.cloud1.ch10.trace.stream.user.entity.User;
import com.zccoder.cloud1.ch10.trace.stream.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制类
 * @author ZhangCheng on 2017-07-17 13:15
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
