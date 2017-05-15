package com.ray.base.common.interceptor;

import com.ray.base.common.Constants;
import com.ray.base.common.util.BaseUrlUtils;
import com.ray.core.model.UserAdmin;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录拦截器
 * @author TY
 *
 */
public class CheckLoginInterceptor extends HandlerInterceptorAdapter {

    /**
     * 通用dao
     */
    
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @SuppressWarnings("static-access")
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        // 定义返回值变量
        boolean bool = true;
        String url = request.getRequestURL().toString();
        url = url == null ? "" : url;
        System.out.println("requestUrl:"+url);

//        Class<?> clazz = handler.getClass();
//        System.out.println("class:"+clazz);
//        CheckLogin checkLogin = clazz.getAnnotation(CheckLogin.class);

        if(handler.getClass().isAssignableFrom(HandlerMethod.class)){
        	CheckLogin checkLogin = ((HandlerMethod)handler).getMethodAnnotation(CheckLogin.class);
        	if (checkLogin != null) {
                String val = checkLogin.value();
                if (val.equals(checkLogin.ADMIN)) {
                    // 判断后台登录
                    bool = adminLogin(request, response);
                }else if (val.equals(checkLogin.WEB)) {
                    // 判断后台登录
                    bool = webLogin(request, response);
                }
            }

        }
           
            
        
        // 禁止缓存
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "No-cache");
        response.setDateHeader("Expires", 0);
        return bool;
    }


    /**
     * 判断后台用户是否登录
     * 
     * @param request
     *            request
     * @param response
     *            response
     * @return 是否登录
     * @throws ServletException
     *             ServletException
     * @throws IOException
     *             IOException
     */
    private boolean adminLogin(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        UserAdmin user = (UserAdmin) request.getSession().getAttribute(
                Constants.ADMINLOGIN_SUCCESS);
        if (user == null) {
            response.sendRedirect(BaseUrlUtils.rootDirectory(request)
                    + "admin");
            return false;
        }
        return true;
    }
    
    /**
     * 判断前台用户是否登录
     * 
     * @param request
     *            request
     * @param response
     *            response
     * @return 是否登录
     * @throws ServletException
     *             ServletException
     * @throws IOException
     *             IOException
     */
    private boolean webLogin(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        UserAdmin user = (UserAdmin) request.getSession().getAttribute(
                Constants.WEBLOGIN_SUCCESS);
        if (user == null) {
            response.sendRedirect(BaseUrlUtils.rootDirectory(request)
                    + "web");
            return false;
        }
        return true;
    }
    
    
}
