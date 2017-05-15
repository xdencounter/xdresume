package com.ray.core.controller.admin;

import com.ray.base.common.interceptor.SingleLogin;
import com.ray.base.common.util.MD5Encryption;
import com.ray.core.model.UserAdmin;
import com.ray.core.service.UserAdminService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * Created by Administrator on 2017-05-07.
 */
@Controller
public class AdminLoginController {
    @Autowired
    private UserAdminService adminService;
    /**
     * 登录页面
     *
     * @author  xuedongdong
     * @return 登录页面
     */
    @RequestMapping(value = { "/admin"})
    public ModelAndView admin() {
        return new ModelAndView("/WEB-INF/views/admin/login");
    }


    @RequestMapping("adminLogin")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String code = request.getParameter("code");
        String msg = "";
        int isSuccess = 0;
        String sessionCode = (String) request.getSession().getAttribute("verifyCode");

        ModelAndView modelAndView= new ModelAndView();
        if(StringUtils.isBlank(userName)){
            msg = "用户名为空";
        }else if (StringUtils.isBlank(password)) {
            msg = "密码为空";
        }else if (!code.equalsIgnoreCase(sessionCode)) {
            msg = "验证码错误";
        }else {
            //通过用户名查找用户
            Map map = new HashMap();
            map.put("userName", userName);
            UserAdmin userAdmin = adminService.findUserAdmin(map);
            if(userAdmin==null){
                msg="用户名不存在";
            }else {
                //验证密码
                if(userAdmin.getPassword().equals(MD5Encryption.MD5Encode(password, "UTF-8"))){

                    //判断用户状态
                    if(userAdmin.getState()==1){
                        //登录成功
                        isSuccess = 1;
                        HttpSession session = request.getSession();
                        session.setAttribute("adminuser", userAdmin);
                        //单点登录校验
                        SingleLogin.isAlreadyEnter(session, userName);
                        //获取菜单权限
                        List list = adminService.findMenuJurisdictionListByUser(userAdmin.getId());
                        session.setAttribute("menuuser", list);
                    }else {
                        msg = "用户非法";
                    }

                }else {
                    msg = "密码错误";
                }
            }
        }

        if(isSuccess==1){
            modelAndView.setViewName("redirect:/admin/index");
        }else {
            modelAndView.addObject("message", msg);
            modelAndView.setViewName("admin/login");
        }
        return modelAndView;
    }
}