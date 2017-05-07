package com.ray.base.common.util;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 描述：spring上下文环境对象设置，获取类
 *
 * Created by xuedong on 2016/12/16.
 */
public class SpringInit implements ServletContextListener {

	public static ApplicationContext springContext;
	public static ServletContext servletContext;
	/**
	 * 构造器
	 */
	public SpringInit() {
		super();
	}

	/**
	 * 初始化上下文
	 * 
	 * @param event
	 *            ServletContextEvent
	 */
	public void contextInitialized(ServletContextEvent event) {
		springContext = WebApplicationContextUtils
				.getWebApplicationContext(event.getServletContext());
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
	}

	/**
	 * 获取上下文
	 * 
	 * @return ApplicationContext
	 */
	public static ApplicationContext getApplicationContext() {
		return springContext;
	}
	public static ServletContext getServletContext(){
		return servletContext;
	}

}