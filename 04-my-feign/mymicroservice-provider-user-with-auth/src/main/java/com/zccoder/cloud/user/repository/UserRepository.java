package com.zccoder.cloud.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zccoder.cloud.user.entity.User;

/**
 * @title 用户资源类
 * @describe 用户资源类
 * @author zc
 * @version 1.0 2017-12-05
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
