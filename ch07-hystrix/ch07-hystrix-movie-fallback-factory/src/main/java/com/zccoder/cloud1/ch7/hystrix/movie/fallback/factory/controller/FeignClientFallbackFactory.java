package com.zccoder.cloud1.ch7.hystrix.movie.fallback.factory.controller;

import com.zccoder.cloud1.ch7.hystrix.movie.fallback.factory.domain.User;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author zc
 * @version 1.0 2017-12-06
 * @title 实现FallbackFactory接口，并重写create方法
 * @describe 实现FallbackFactory接口，并重写create方法
 */
@Component
class FeignClientFallbackFactory implements FallbackFactory<UserFeignClient> {

    private static final Logger LOGGER = LoggerFactory.getLogger(FeignClientFallbackFactory.class);

    @Override
    public UserFeignClient create(Throwable cause) {
        // 使用匿名内部类方式
        return new UserFeignClient() {
            @Override
            public User findById(Long id) {
                // 日志最好放在各个fallback方法中
                FeignClientFallbackFactory.LOGGER.info("fallback reason was [{}]", cause);

                User user = new User();
                user.setId(-1L);
                user.setName("默认用户");
                return user;
            }
        };
    }
}
