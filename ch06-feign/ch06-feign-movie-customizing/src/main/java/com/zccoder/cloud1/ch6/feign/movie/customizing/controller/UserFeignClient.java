package com.zccoder.cloud1.ch6.feign.movie.customizing.controller;

import com.zccoder.cloud1.ch6.feign.movie.FeignConfiguration;
import com.zccoder.cloud1.ch6.feign.movie.customizing.domain.User;
import org.springframework.cloud.netflix.feign.FeignClient;

import feign.Param;
import feign.RequestLine;

/**
 * @author zc
 * @version 1.0 2017-12-05
 * @title Feign接口
 * @describe Feign接口
 * // @FeignClient注解中name值mymicroservice-provider-user是一个任意的客户端名称，用户创建Ribbon负载均衡器
 * // @FeignClient注解中configuration值指定配置类
 */
@FeignClient(name = "mymicroservice-provider-user", configuration = FeignConfiguration.class)
public interface UserFeignClient {

    /**
     * 通过ID查找用户
     * 使用feign自带的注解@RequestLine
     *
     * @param id ID
     * @return 用户
     */
    @RequestLine("GET /{id}")
    User findById(@Param("id") Long id);

}
