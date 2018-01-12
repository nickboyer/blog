/*
 * Copyright 2015 nickboyer.cn All rights reserved
 * 
 * @author Kang.Y
 * 
 * @mail
 * 
 * @createtime 2018年1月12日 下午12:18:26
 */
package cn.nickboyer.blog.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.nickboyer.blog.entry.Blogs;
import cn.nickboyer.blog.server.service.ISolrService;

/**
 * @title
 * @description
 * @author Kang.Y
 * @since JDK1.8
 */
@RestController
@RequestMapping("/solr")
public class SolrController {

	@Autowired
	private ISolrService solrService;

	@RequestMapping("/search")
	List<Blogs> search(String wd) {
		return solrService.search(wd);
	}
}
