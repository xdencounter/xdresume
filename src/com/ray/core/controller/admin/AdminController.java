package com.ray.core.controller.admin;

import com.ray.core.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017-05-07.
 */
@RequestMapping("admin")
@Controller
public class AdminController {
    @Autowired
    private MenuService menuService;

    /**
     * 后台主菜单首页
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("index")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/index");
        return modelAndView;
    }
}