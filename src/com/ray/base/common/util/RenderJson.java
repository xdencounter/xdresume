package com.ray.base.common.util;


import com.ray.base.common.bean.Render;
import com.ray.base.common.exceptions.UnexpectedException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 描述：ajax方式传输json对象
 * Created by xuedong on 2016/12/16.
 */
public class RenderJson extends Render {

	String a;
	
	
	
	/**
	 * 构造函数，参数为字符串
	 * @param s String
	 */
	public RenderJson(String s) {
		a = s;
	}
	
	/**
	 * 构造函数，参数为字符串、状态
	 * @param s String
	 * @param i int
	 */
	public RenderJson(String s, int i) {
		a = s;
		status = i;
		setStauts = true;
	}
	
	/**
	 * JSON与对象转换
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 */
	public void render(HttpServletRequest request, HttpServletResponse response) {
		setContentType(response, "application/json; charset=utf-8");
		try {
			if (setStauts){
				response.setStatus(status);
			}
			response.getOutputStream().write(a.getBytes("utf-8"));
		} catch (Exception exception) {
			logger.error("render json error.{}", a, exception);
			throw new UnexpectedException(StringUtil.format(
					"render json error. {0}", new String[] { a }), exception,
					true);
		}
	}

	
}
