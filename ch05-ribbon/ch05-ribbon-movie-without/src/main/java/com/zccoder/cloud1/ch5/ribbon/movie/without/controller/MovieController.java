package com.zccoder.cloud1.ch5.ribbon.movie.without.controller;

import com.zccoder.cloud1.ch5.ribbon.movie.without.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 * @title Rest接口类
 * @describe Rest接口类
 * @author zc
 * @version 1.0 2017-12-04
 */
@RestController
public class MovieController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);
	
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	@GetMapping("/user/{id}")
	public User findById(@PathVariable Long id){
		return this.restTemplate.getForObject("http://mymicroservice-provider-user/" + id , User.class);
	}
	
	@GetMapping("/log-instance")
	public void logUserInstance(){
		ServiceInstance serviceInstance = this.loadBalancerClient.choose("mymicroservice-provider-user");
		// 打印当前选择的是哪点节点
		MovieController.LOGGER.info("{}:{}:{}",serviceInstance.getServiceId(),serviceInstance.getHost(),serviceInstance.getPort());
	}
}
