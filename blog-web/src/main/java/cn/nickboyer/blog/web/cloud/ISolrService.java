/*
 * Copyright 2015 nickboyer.cn All rights reserved
 * 
 * @author Kang.Y
 * 
 * @mail
 * 
 * @createtime 2018年1月12日 下午12:17:12
 */
package cn.nickboyer.blog.web.cloud;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.nickboyer.blog.entry.Blogs;

/**
 * @title
 * @description
 * @author Kang.Y
 * @since JDK1.8
 */
@FeignClient(value = "blog-server")
@RequestMapping("/solr")
public interface ISolrService {

	/**
	 * @param wd
	 * @return
	 *
	 * @authz Kang.Y
	 * @createtime 2018年1月12日 上午11:56:27
	 */
	@RequestMapping("/search")
	List<Blogs> search(@RequestParam("wd") String wd);
}
