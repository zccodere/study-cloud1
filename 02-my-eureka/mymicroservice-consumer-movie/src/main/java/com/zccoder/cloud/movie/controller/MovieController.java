package com.zccoder.cloud.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.zccoder.cloud.movie.domain.User;

/**
 * 电影控制类
 * @author ZhangCheng on 2017-07-18 13:26
 *
 */
@RestController
public class MovieController {
	
	@Autowired
	private RestTemplate restTemplate;
	@Value("${user.userServiceUrl}")
	private String userServiceUrl;
	
	@GetMapping("/user/{id}")
	public User findById(@PathVariable Long id){
		return this.restTemplate.getForObject(this.userServiceUrl + id , User.class);
	}
}
