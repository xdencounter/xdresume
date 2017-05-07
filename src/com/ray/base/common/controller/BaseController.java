package com.ray.base.common.controller;

import org.springframework.web.servlet.ModelAndView;

public class BaseController {
	/**
	 * 获取警告视图
	 * 
	 * @param message
	 * @return
	 */
	public ModelAndView getWarningView(String message) {
		ModelAndView m = new ModelAndView("WEB-INF/jsp/common/warning");
		m.addObject("message", message);
		return m;
	}
}
