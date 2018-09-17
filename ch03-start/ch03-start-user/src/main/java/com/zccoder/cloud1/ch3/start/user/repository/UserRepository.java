package com.zccoder.cloud1.ch3.start.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zccoder.cloud1.ch3.start.user.entity.User;

/**
 * 用户资源类
 * @author ZhangCheng on 2017-07-17 13:12
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
