/*
 * Copyright 2015 nickboyer.cn All rights reserved
 * 
 * @author Kang.Y
 * 
 * @mail
 * 
 * @createtime 2018年1月4日 下午4:21:03
 */
package cn.nickboyer.blog.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @title
 * @description
 * @author Kang.Y
 * @since JDK1.8
 */
@Controller
public class AdminController extends BaseComponent {

	/**
	 * 首页
	 * 
	 * @param mv
	 * @param req
	 * @return
	 *
	 * @authz Kang.Y
	 * @createtime 2018年1月3日 下午12:05:00
	 */
	@RequestMapping("/about")
	public ModelAndView index(ModelAndView mv) {

		mv.setViewName("about");
		return mv;

	}
}
