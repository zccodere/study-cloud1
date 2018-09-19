package com.zccoder.cloud1.ch8.zuul.fallback;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;

/**
 * @title 回退类
 * @describe 实现ZuulFallbackProvider接口
 * @author zc
 * @version 1.0 2017-12-11
 */
public class UserFallbackProvider implements ZuulFallbackProvider{

	@Override
	public String getRoute() {
		// 指定为哪个微服务提供回退
		return "mymicroservice-provider-user";
	}
	
	@Override
	public ClientHttpResponse fallbackResponse() {
		return new ClientHttpResponse(){

			@Override
			public InputStream getBody() throws IOException {
				// 响应体
				return new ByteArrayInputStream("用户微服务不可用，请稍后再试。".getBytes());
			}

			@Override
			public HttpHeaders getHeaders() {
				// headers设定
				HttpHeaders headers = new HttpHeaders();
				MediaType mt = new MediaType("application","json",Charset.forName("UTF-8"));
				headers.setContentType(mt);
				return headers;
			}

			@Override
			public void close() {
			}

			@Override
			public int getRawStatusCode() throws IOException {
				return this.getStatusCode().value();
			}

			@Override
			public HttpStatus getStatusCode() throws IOException {
				return HttpStatus.OK;
			}

			@Override
			public String getStatusText() throws IOException {
				return this.getStatusCode().getReasonPhrase();
			}
		};
	}

}
