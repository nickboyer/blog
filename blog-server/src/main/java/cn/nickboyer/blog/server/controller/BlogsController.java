/*
 * Copyright 2014 Buyforyou.cn All rights reserved
 * 
 * @author Kang.Y
 * 
 * @mail
 * 
 * @createtime 2018年1月4日 上午12:00:12
 */
package cn.nickboyer.blog.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.nickboyer.blog.common.Page;
import cn.nickboyer.blog.entry.Archives;
import cn.nickboyer.blog.entry.Blogs;
import cn.nickboyer.blog.entry.Categories;
import cn.nickboyer.blog.entry.Tags;
import cn.nickboyer.blog.server.service.IBlogsService;

/**
 * @title
 * @description
 * @since JDK1.8
 */
@RestController
@RequestMapping("/blogs")
public class BlogsController {

	@Autowired
	private IBlogsService blogService;

	@RequestMapping("/list")
	Page<Blogs> findList(Blogs blogs, String pageNum, String pageSize) {
		return blogService.findList(blogs, pageNum, pageSize);
	}

	@RequestMapping("/detail")
	Blogs findDetail(String id) {
		return blogService.findDetail(id);
	}

	@RequestMapping("/tag")
	List<Tags> findTags() {
		return blogService.findTags();
	}

	@RequestMapping("/tag_single")
	Tags findTag(String id) {
		return blogService.findTag(id);
	}

	@RequestMapping("/archive")
	List<Archives> findArchives() {
		return blogService.findArchives();
	}

	@RequestMapping("/category")
	List<Categories> findCategories() {
		return blogService.findCategories();
	}

	@RequestMapping("/category_single")
	Categories findCategory(String id) {
		return blogService.findCategory(id);
	}

}
