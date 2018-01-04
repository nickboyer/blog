/*
 * Copyright 2015 nickboyer.cn All rights reserved
 * 
 * @author Kang.Y
 * 
 * @mail
 * 
 * @createtime 2018年1月3日 上午11:15:32
 */
package cn.nickboyer.blog.web.cloud;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.nickboyer.blog.common.Page;
import cn.nickboyer.blog.entry.Blogs;
import cn.nickboyer.blog.entry.Tags;

/**
 * @title
 * @description
 * @author Kang.Y
 * @since JDK1.8
 */
@FeignClient(value = "blog-server")
@RequestMapping("/blogs")
public interface IBlogsService {

	/**
	 * @param blogs
	 * @param pageNum
	 * @param pageSize
	 * @return
	 *
	 * @authz Kang.Y
	 * @createtime 2018年1月3日 下午12:05:16
	 */
	@RequestMapping("/list")
	Page<Blogs> findList(@RequestParam("blogs") Blogs blogs, @RequestParam("pageNum") String pageNum, @RequestParam("pageSize") String pageSize);

	/**
	 * @param id
	 * @return
	 *
	 * @authz Kang.Y
	 * @createtime 2018年1月4日 下午1:14:35
	 */
	@RequestMapping("/detail")
	Blogs findDetail(@RequestParam("id") String id);

	/**
	 * @return
	 *
	 * @authz Kang.Y
	 * @createtime 2018年1月4日 下午4:47:36
	 */
	@RequestMapping("/tag")
	List<Tags> findTags();

	/**
	 * @param id
	 * @return
	 *
	 * @authz Kang.Y
	 * @createtime 2018年1月4日 下午4:48:45
	 */
	@RequestMapping("/tag_single")
	Tags findTag(String id);

	/**
	 * @param id
	 * @return
	 *
	 * @authz Kang.Y
	 * @createtime 2018年1月4日 下午4:57:40
	 */
	@RequestMapping("/tag_blogs")
	List<Blogs> findBlogsByTagId(String id);

}
