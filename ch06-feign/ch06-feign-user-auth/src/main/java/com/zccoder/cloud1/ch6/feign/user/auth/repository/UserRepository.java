package com.zccoder.cloud1.ch6.feign.user.auth.repository;

import com.zccoder.cloud1.ch6.feign.user.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @title 用户资源类
 * @describe 用户资源类
 * @author zc
 * @version 1.0 2017-12-05
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
