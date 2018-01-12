/*
 * Copyright 2015 nickboyer.cn All rights reserved
 * 
 * @author Kang.Y
 * 
 * @mail
 * 
 * @createtime 2018年1月12日 下午12:06:16
 */
package cn.nickboyer.blog.server.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.stereotype.Service;

import cn.nickboyer.blog.entry.Blogs;
import cn.nickboyer.blog.server.service.ISolrService;

/**
 * @title
 * @description
 * @author Kang.Y
 * @since JDK1.8
 */
@Service
public class SolrServiceImpl implements ISolrService {

	@Autowired
	private SolrTemplate solrTemplate;

	/**
	 * （no Javadoc）
	 * 
	 * @see cn.nickboyer.blog.server.service.ISolrService#search(java.lang.String)
	 */
	@Override
	public List<Blogs> search(String wd) {
		SolrClient solr = solrTemplate.getSolrClient();
		SolrQuery query = new SolrQuery();
		query.set("q", "header:" + wd);
		query.setHighlight(true);
		query.addHighlightField("header");
		query.setHighlightSimplePre("<font color='red'>");
		query.setHighlightSimplePost("</font>");
		QueryResponse response = null;
		try {
			response = solr.query(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Map<String, List<String>>> highlighting = response.getHighlighting();
		List<Blogs> blogs = new ArrayList<>();
		Blogs blog = null;
		for (Entry<String, Map<String, List<String>>> entry : highlighting.entrySet()) {
			blog = new Blogs();
			blog.setId(Integer.valueOf(entry.getKey()));
			blog.setHeader(entry.getValue().get("header").get(0));
			blogs.add(blog);
		}
		return blogs;
	}

}
