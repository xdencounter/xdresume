package com.ray.core.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ray.base.util.VerifyCodeUtils;

@Controller
public class VerifyCodeController {

	@RequestMapping("verifyCode")
	public void register(HttpServletRequest request,
			HttpServletResponse response) throws  ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		  //获取HttpSession对象
		  HttpSession session=request.getSession();
		   //设置参数
		   
		   //设置响应类型,输出图片客户端不缓存
		   response.setDateHeader("Expires", 1L);  
		   response.setHeader("Cache-Control", "no-cache, no-store, max-age=0");
		   response.addHeader("Pragma", "no-cache");
		   response.setContentType("image/jpeg"); 
		   //输出到页面
		   //获取随机字符串
		   String randomStr=VerifyCodeUtils.random(4);
		   session.setAttribute("verifyCode", randomStr);
		   System.out.println(randomStr);
		   System.out.println(session.getAttribute("verifyCode"));
		   //生成图片
		   VerifyCodeUtils.render(randomStr, response.getOutputStream(),80,30);
		   
	}
}
