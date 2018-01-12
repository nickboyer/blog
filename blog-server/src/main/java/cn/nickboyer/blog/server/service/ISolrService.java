/*
 * Copyright 2015 nickboyer.cn All rights reserved
 * 
 * @author Kang.Y
 * 
 * @mail
 * 
 * @createtime 2018年1月12日 下午12:05:48
 */
package cn.nickboyer.blog.server.service;

import java.util.List;

import cn.nickboyer.blog.entry.Blogs;

/**
 * @title
 * @description
 * @author Kang.Y
 * @since JDK1.8
 */
public interface ISolrService {

	/**
	 * @param wd
	 * @return
	 *
	 * @authz Kang.Y
	 * @createtime 2018年1月12日 下午12:19:32
	 */
	List<Blogs> search(String wd);

}
