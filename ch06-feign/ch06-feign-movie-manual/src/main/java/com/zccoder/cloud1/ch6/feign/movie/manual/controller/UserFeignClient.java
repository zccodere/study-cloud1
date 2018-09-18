package com.zccoder.cloud1.ch6.feign.movie.manual.controller;

import com.zccoder.cloud1.ch6.feign.movie.manual.domain.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author zc
 * @version 1.0 2017-12-05
 * @title Feign接口
 * @describe Feign接口
 */
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
