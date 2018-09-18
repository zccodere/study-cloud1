package com.zccoder.cloud1.ch7.hystrix.movie.fallback.controller;

import com.zccoder.cloud1.ch7.hystrix.movie.fallback.domain.User;
import org.springframework.stereotype.Component;

/**
 * @author zc
 * @version 1.0 2017-12-06
 * @title 回退类FeignClientFallback需实现Feign Client接口
 * @describe FeignClientFallback也可以是public class，没有区别
 */
@Component
class FeignClientFallback implements UserFeignClient {

    @Override
    public User findById(Long id) {
        User user = new User();
        user.setId(-1L);
        user.setName("默认用户");
        return user;
    }

}
