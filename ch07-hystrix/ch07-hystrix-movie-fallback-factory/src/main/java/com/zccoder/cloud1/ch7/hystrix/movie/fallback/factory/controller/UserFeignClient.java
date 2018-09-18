package com.zccoder.cloud1.ch7.hystrix.movie.fallback.factory.controller;

import com.zccoder.cloud1.ch7.hystrix.movie.fallback.factory.domain.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author zc
 * @version 1.0 2017-12-06
 * // @FeignClient注解中name值mymicroservice-provider-user是一个任意的客户端名称，用户创建Ribbon负载均衡器
 * @title Feign接口
 * @describe Feign接口
 */
@FeignClient(name = "mymicroservice-provider-user", fallbackFactory = FeignClientFallbackFactory.class)
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
