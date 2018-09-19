package com.zccoder.cloud1.ch8.zuul.aggregation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zccoder.cloud1.ch8.zuul.aggregation.domain.User;

import rx.Observable;

/**
 * @title 业务类
 * @describe 业务服务类
 * @author zc
 * @version 1.0 2017-12-12
 */
@Service
public class AggregationService {
	
	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod="fallback")
	public Observable<User> getUserById(Long id){
		
		// 创建一个被观察者
		return Observable.create(observer -> {
			// 请求用户微服务的/{id}端点
			User user = restTemplate.getForObject("http://mymicroservice-provider-user/{id}", User.class,id);
			observer.onNext(user);
			observer.onCompleted();
		});
	}
	
	@HystrixCommand(fallbackMethod="fallback")
	public Observable<User> getMovieUserByUserId(Long id){
		return Observable.create(observer -> {
			// 请求电影微服务的/user/{id}端点
			User user = restTemplate.getForObject("http://mymicroservice-consumer-movie/user/{id}", User.class,id);
			observer.onNext(user);
			observer.onCompleted();
		});
	}
	
	public User fallback(Long id){
		User user = new User();
		user.setId(-1L);
		return user;
	}
}
