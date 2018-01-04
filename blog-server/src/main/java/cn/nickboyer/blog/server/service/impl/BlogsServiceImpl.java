/*
 * Copyright 2015 nickboyer.cn All rights reserved
 * 
 * @author Kang.Y
 * 
 * @mail
 * 
 * @createtime 2018年1月3日 下午12:06:11
 */
package cn.nickboyer.blog.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.nickboyer.blog.common.Page;
import cn.nickboyer.blog.entry.Blogs;
import cn.nickboyer.blog.entry.Tags;
import cn.nickboyer.blog.server.mapper.BlogsMapper;
import cn.nickboyer.blog.server.mapper.TagsMapper;
import cn.nickboyer.blog.server.service.BaseService;
import cn.nickboyer.blog.server.service.IBlogsService;

/**
 * @title
 * @description
 * @author Kang.Y
 * @since JDK1.8
 */
@Service
public class BlogsServiceImpl extends BaseService implements IBlogsService {

	@Autowired
	private BlogsMapper blogsMapper;
	@Autowired
	private TagsMapper tagsMapper;

	/**
	 * （no Javadoc）
	 * 
	 * @see cn.nickboyer.blog.api.service.IBlogsService#findList(cn.nickboyer.blog.api.entry.Blogs, java.lang.String, java.lang.String)
	 */
	@Override
	public Page<Blogs> findList(Blogs blogs, String pageNum, String pageSize) {

		com.github.pagehelper.Page<Blogs> page = PageHelper.startPage(Integer.valueOf(pageNum), Integer.valueOf(pageSize), true);
		blogsMapper.selectList();
		return new Page<Blogs>(page);
	}

	/**
	 * （no Javadoc）
	 * 
	 * @see cn.nickboyer.blog.server.service.IBlogsService#findDetail(java.lang.String)
	 */
	@Override
	public Blogs findDetail(String id) {
		Blogs blog = blogsMapper.selectById(id);
		List<Tags> tags = blogsMapper.selectTagsById(id);
		blog.setTags(tags);
		return blog;
	}

	/**
	 * （no Javadoc）
	 * 
	 * @see cn.nickboyer.blog.server.service.IBlogsService#findTags()
	 */
	@Override
	public List<Tags> findTags() {
		return tagsMapper.selectAll();
	}

	/**
	 * （no Javadoc）
	 * 
	 * @see cn.nickboyer.blog.server.service.IBlogsService#findTag(java.lang.String)
	 */
	@Override
	public Tags findTag(String id) {
		return tagsMapper.selectById(id);
	}

	/**
	 * （no Javadoc）
	 * 
	 * @see cn.nickboyer.blog.server.service.IBlogsService#findBlogsByTagId(java.lang.String)
	 */
	@Override
	public List<Blogs> findBlogsByTagId(String id) {
		return tagsMapper.selectBlogsByTagId(id);
	}

}
