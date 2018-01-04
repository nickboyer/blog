/*
 * Copyright 2015 nickboyer.cn All rights reserved
 * 
 * @author Kang.Y
 * 
 * @mail
 * 
 * @createtime 2018年1月3日 上午11:15:32
 */
package cn.nickboyer.blog.server.service;

import java.util.List;

import cn.nickboyer.blog.common.Page;
import cn.nickboyer.blog.entry.Blogs;
import cn.nickboyer.blog.entry.Tags;

/**
 * @title
 * @description
 * @author Kang.Y
 * @since JDK1.8
 */
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
	Page<Blogs> findList(Blogs blogs, String pageNum, String pageSize);

	/**
	 * @param id
	 * @return
	 *
	 * @authz Kang.Y
	 * @createtime 2018年1月4日 下午1:15:45
	 */
	Blogs findDetail(String id);

	/**
	 * @return
	 *
	 * @authz Kang.Y
	 * @createtime 2018年1月4日 下午4:49:51
	 */
	List<Tags> findTags();

	/**
	 * @param id
	 * @return
	 *
	 * @authz Kang.Y
	 * @createtime 2018年1月4日 下午4:49:54
	 */
	Tags findTag(String id);

	/**
	 * @param id
	 * @return
	 *
	 * @authz Kang.Y
	 * @createtime 2018年1月4日 下午4:58:23
	 */
	List<Blogs> findBlogsByTagId(String id);

}
