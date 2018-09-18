package com.zccoder.cloud1.ch6.feign.movie;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Contract;

/**
 * @title 该类为Feign的配置类
 * @describe 该类不应该在主应用程序上下文的@ComponentScan中
 * @author zc
 * @version 1.0 2017-12-05
 */
@Configuration
public class FeignConfiguration {

	/**
	 * 将契约改为feign原生的默认契约。这样就可以使用feign自带的注解了。
	 */
	@Bean
	public Contract feignContract() {
		return new feign.Contract.Default();
	}

}
