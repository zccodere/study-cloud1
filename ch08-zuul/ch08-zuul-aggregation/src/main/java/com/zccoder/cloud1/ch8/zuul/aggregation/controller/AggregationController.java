package com.zccoder.cloud1.ch8.zuul.aggregation.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import com.google.common.collect.Maps;
import com.zccoder.cloud1.ch8.zuul.aggregation.domain.User;
import com.zccoder.cloud1.ch8.zuul.aggregation.service.AggregationService;

import rx.Observable;
import rx.Observer;

/**
 * @title 控制类
 * @describe 在Controller中聚合多个请求
 * @author zc
 * @version 1.0 2017-12-12
 */
@RestController
public class AggregationController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AggregationController.class);
	
	@Autowired
	private AggregationService aggregationService;
	
	@GetMapping("/aggregate/{id}")
	public DeferredResult<HashMap<String,User>> aggregate(@PathVariable Long id){
		LOGGER.info("id is [{}]",id);
		Observable<HashMap<String,User>> result = this.aggregateObservable(id);
		return this.toDeferredResult(result);
	}

	private Observable<HashMap<String, User>> aggregateObservable(Long id) {
		// 合并两个或者多个Observable发射出的数据项，根据指定的函数变换他们
		return Observable.zip(
				this.aggregationService.getUserById(id),
				this.aggregationService.getMovieUserByUserId(id),
				(user,movieUser) -> {
					HashMap<String,User> map = Maps.newHashMap();
					map.put("user", user);
					map.put("movieUser", movieUser);
					return map;
				}
		);
	}
	
	private DeferredResult<HashMap<String, User>> toDeferredResult(Observable<HashMap<String, User>> details) {
		DeferredResult<HashMap<String, User>> result = new DeferredResult<>();
		// 订阅
		details.subscribe(new Observer<HashMap<String, User>>(){
			@Override
			public void onCompleted() {
				LOGGER.info("完成...");
			}
			@Override
			public void onError(Throwable throwable) {
				LOGGER.info("发生错误...{}",throwable);
			}
			@Override
			public void onNext(HashMap<String, User> movieDetails) {
				result.setResult(movieDetails);
			}
		});
		return result;
	}
}
