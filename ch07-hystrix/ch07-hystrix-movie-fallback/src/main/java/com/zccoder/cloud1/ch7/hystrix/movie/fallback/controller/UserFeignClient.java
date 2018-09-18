package com.zccoder.cloud1.ch7.hystrix.movie.fallback.controller;

import com.zccoder.cloud1.ch7.hystrix.movie.fallback.domain.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author zc
 * @version 1.0 2017-12-06
 * // @FeignClient注解中name值mymicroservice-provider-user是一个任意的客户端名称，用户创建Ribbon负载均衡器
 * @title Feign的fallback测试
 * @describe 使用@FeignClient的fallback属性指定回退类
 */
@FeignClient(name = "mymicroservice-provider-user", fallback = FeignClientFallback.class)
public interface UserFeignClient {
    /**
     * 通过ID查找用户
     *
     * @param id ID
     * @return 用户
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    User findById(@PathVariable("id") Long id);

}
