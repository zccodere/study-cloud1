package com.zccoder.cloud.config.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @title 控制类
 * @describe 测试rest类
 * @author zc
 * @version 1.0 2017-12-14
 */
@RestController
// 添加@RefreshScope的类会在配置更改时得到特殊处理
@RefreshScope
public class ClientRest {

	@Value("${profile}")
	private String profile;
	
	@GetMapping("/profile")
	public String hello(){
		return this.profile;
	}
	
}
