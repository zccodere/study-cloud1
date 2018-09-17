package com.zccoder.cloud1.ch04.eureka.movie.metadata.controller;

import java.util.List;

import com.zccoder.cloud1.ch04.eureka.movie.metadata.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 电影控制类
 *
 * @author ZhangCheng on 2017-07-19 13:01
 */
@RestController
public class MovieController {

    @Value("${user.userServiceUrl}")
    private String userServiceUrl;

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient siscoveryClient;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        return this.restTemplate.getForObject(this.userServiceUrl + id, User.class);
    }

    /**
     * 查询mymicroservice-provider-user服务的信息并返回
     *
     * @return mymicroservice-provider-user服务的信息
     */
    @GetMapping(value = "/user-instance", produces = "application/json;charset=UTF-8")
    public List<ServiceInstance> showInfo() {
        return this.siscoveryClient.getInstances("mymicroservice-provider-user");
    }
}
