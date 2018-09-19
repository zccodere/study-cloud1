package com.zccoder.cloud1.ch10.trace.stream.movie.controller;

import com.zccoder.cloud1.ch10.trace.stream.movie.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 电影控制类
 * @author ZhangCheng on 2017-07-17 13:39
 *
 */
@RestController
public class MovieController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/user/{id}")
	public User findById(@PathVariable Long id){
		return this.restTemplate.getForObject("http://localhost:8000/" + id , User.class);
	}
}
