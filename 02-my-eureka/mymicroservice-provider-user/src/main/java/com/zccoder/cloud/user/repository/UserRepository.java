package com.zccoder.cloud.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zccoder.cloud.user.entity.User;

/**
 * 用户资源类
 * @author ZhangCheng on 2017-07-18 13:21
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
