package com.ray.base.common.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;


public class AdminLoginInterceptor extends HandlerInterceptorAdapter {

	private static final String[] IGNORE_URI = {"resource","adminLogin"};

	private List<String> excludedUrls;

	public void setExcludedUrls(List<String> excludedUrls) {
		this.excludedUrls = excludedUrls;
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
							 HttpServletResponse response, Object handler) throws Exception {
		
		
		boolean flag = false;


		String url = request.getRequestURL().toString();
		 
		for (String s : IGNORE_URI) {
			if (url.contains(s)) {
				flag = true;
				break;
			}
			if(url.endsWith("admin.do")){
				flag = true;
				break;
			}
		}
		if (!flag) {
			if(url.contains("admin.do")){
				HttpSession session = request.getSession();
				
				if (session.getAttribute("adminuser") == null) {
					response.sendRedirect(request.getContextPath() + "/admin");
				} else {
					if(SingleLogin.isOnline(session)==true){
						return true;
					}else {
						session.invalidate();
						response.sendRedirect(request.getContextPath() + "/admin");
					}
					
				}
			}else {
				flag = true;
			}
			
		}
		return flag;
	}

	@Override
	public void postHandle(HttpServletRequest request,
						   HttpServletResponse response, Object handler,
						   ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}
}
