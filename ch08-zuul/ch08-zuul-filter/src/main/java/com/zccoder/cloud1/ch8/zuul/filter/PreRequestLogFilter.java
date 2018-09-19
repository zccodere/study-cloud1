package com.zccoder.cloud1.ch8.zuul.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * @title 自定义过滤器
 * @describe 自定义Zuul过滤器
 * @author zc
 * @version 1.0 2017-12-11
 */
public class PreRequestLogFilter extends ZuulFilter{

	private static final Logger LOGGER = LoggerFactory.getLogger(PreRequestLogFilter.class);
	
	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		PreRequestLogFilter.LOGGER.info(String.format("send %s request to %s", request.getMethod(),request.getRequestURI().toString()));
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public String filterType() {
		return "pre";
	}

}
