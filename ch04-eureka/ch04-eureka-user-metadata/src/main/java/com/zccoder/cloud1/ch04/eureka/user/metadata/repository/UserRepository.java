package com.zccoder.cloud1.ch04.eureka.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zccoder.cloud1.ch04.eureka.user.entity.User;

/**
 * 用户资源类
 * @author ZhangCheng on 2017-07-19 12:54
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
