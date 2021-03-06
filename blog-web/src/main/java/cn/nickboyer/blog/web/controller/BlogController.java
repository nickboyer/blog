/*
 * Copyright 2015 nickboyer.cn All rights reserved
 * 
 * @author Kang.Y
 * 
 * @mail
 * 
 * @createtime 2018年1月3日 上午11:07:59
 */
package cn.nickboyer.blog.web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.nickboyer.blog.common.Page;
import cn.nickboyer.blog.entry.Archives;
import cn.nickboyer.blog.entry.Blogs;
import cn.nickboyer.blog.entry.Categories;
import cn.nickboyer.blog.entry.Tags;
import cn.nickboyer.blog.web.cloud.IBlogsService;
import cn.nickboyer.blog.web.cloud.IRedisService;
import cn.nickboyer.blog.web.cloud.ISolrService;

/**
 * @title
 * @description
 * @author Kang.Y
 * @since JDK1.8
 */
@Controller
public class BlogController extends BaseComponent {

	@Autowired
	private IBlogsService blogsService;
	@Autowired
	private IRedisService redisService;
	@Autowired
	private ISolrService solrService;

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
	@RequestMapping("/index")
	public ModelAndView index(ModelAndView mv, HttpServletRequest req) {
		// 获取所有数据
		String pageNum = StringUtils.isEmpty(req.getParameter("pageNum")) ? "1" : req.getParameter("pageNum");
		String pageSize = StringUtils.isEmpty(req.getParameter("pageSize")) ? "6" : req.getParameter("pageSize");
		Page<Blogs> page = blogsService.findList(new Blogs(), pageNum, pageSize);
		mv.addObject("page", page);
		// 获取字典数据
		Map<String, String> dicts = redisService.findAllDicts();
		mv.addObject("dicts", dicts);
		mv.setViewName("index");
		return mv;

	}

	@RequestMapping("/detail")
	public ModelAndView detail(ModelAndView mv, HttpServletRequest req) {

		String id = req.getParameter("id");
		if (StringUtils.isEmpty(id)) {
			// 跳转首页
			Page<Blogs> page = blogsService.findList(new Blogs(), "1", "6");
			mv.addObject("page", page);
			mv.setViewName("index");
		} else {
			// 获取详情数据
			Blogs blog = blogsService.findDetail(id);
			mv.addObject("blog", blog);
			mv.setViewName("detail");
		}

		// 获取字典数据
		Map<String, String> dicts = redisService.findAllDicts();
		mv.addObject("dicts", dicts);
		return mv;
	}

	@RequestMapping("/tag")
	public ModelAndView tag(ModelAndView mv, HttpServletRequest req) {

		String id = req.getParameter("id");
		if (StringUtils.isEmpty(id)) {
			// 跳转标签首页
			List<Tags> tags = blogsService.findTags();
			mv.addObject("tags", tags);
			mv.setViewName("tags");
		} else {
			// 获取详情数据
			Tags tag = blogsService.findTag(id);
			mv.addObject("tag", tag);
			mv.setViewName("tags_single");
		}

		// 获取字典数据
		Map<String, String> dicts = redisService.findAllDicts();
		mv.addObject("dicts", dicts);
		return mv;
	}

	@RequestMapping("/archive")
	public ModelAndView archive(ModelAndView mv) {

		List<Archives> archives = blogsService.findArchives();
		mv.addObject("archives", archives);
		// 获取字典数据
		Map<String, String> dicts = redisService.findAllDicts();
		mv.addObject("dicts", dicts);
		mv.setViewName("archives");
		return mv;
	}

	@RequestMapping("/category")
	public ModelAndView category(ModelAndView mv, HttpServletRequest req) {

		String id = req.getParameter("id");
		if (StringUtils.isEmpty(id)) {
			// 跳转分类首页
			List<Categories> categories = blogsService.findCategories();
			mv.addObject("categories", categories);
			mv.setViewName("categories");
		} else {
			// 获取详情数据
			Categories category = blogsService.findCategory(id);
			mv.addObject("category", category);
			mv.setViewName("categories_single");
		}
		// 获取字典数据
		Map<String, String> dicts = redisService.findAllDicts();
		mv.addObject("dicts", dicts);
		return mv;
	}

	@RequestMapping("/search")
	@ResponseBody
	public Object search(HttpServletRequest req) {
		String wd = req.getParameter("wd");
		if (StringUtils.isEmpty(wd)) {
			return null;
		} else {
			List<Blogs> blogs = solrService.search(wd);
			return blogs;
		}
	}
}
