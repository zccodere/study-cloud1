package com.zccoder.cloud1.ch6.feign.user.auth.controller;

import java.util.Collection;

import com.zccoder.cloud1.ch6.feign.user.auth.entity.User;
import com.zccoder.cloud1.ch6.feign.user.auth.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @title 用户控制类
 * @describe 用户控制类
 * @author zc
 * @version 1.0 2017-12-05
 */
@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@GetMapping("/{id}")
	public User findById(@PathVariable Long id){
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal instanceof UserDetails){
			UserDetails user = (UserDetails)principal;
			Collection<? extends GrantedAuthority> collection = user.getAuthorities();
			for (GrantedAuthority c : collection) {
				// 打印当前登录用户的信息
				UserController.LOGGER.info("当前用户是{}，角色是{}",user.getUsername(),c.getAuthority());
			}
		}else{
			// do other things
		}
		User findOne = userRepository.findOne(id);
		return findOne;
	}
}
