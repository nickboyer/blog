/*
 * Copyright 2015 nickboyer.cn All rights reserved
 * 
 * @author Kang.Y
 * 
 * @mail
 * 
 * @createtime 2018年1月4日 下午4:50:51
 */
package cn.nickboyer.blog.server.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import cn.nickboyer.blog.entry.Blogs;
import cn.nickboyer.blog.entry.Tags;

/**
 * @title
 * @description
 * @author Kang.Y
 * @since JDK1.8
 */
@Mapper
public interface TagsMapper {

	/**
	 * @return
	 *
	 * @authz Kang.Y
	 * @createtime 2018年1月4日 下午4:52:26
	 */
	@Select("select * from tags")
	List<Tags> selectAll();

	/**
	 * @param id
	 * @return
	 *
	 * @authz Kang.Y
	 * @createtime 2018年1月4日 下午4:56:13
	 */
	@Select("select * from tags where id = #{id}")
	Tags selectById(String id);

	/**
	 * @param id
	 * @return
	 *
	 * @authz Kang.Y
	 * @createtime 2018年1月4日 下午4:58:56
	 */
	@Select("select a.* from blogs a,blog_tag_relation b where a.id = b.blog_id and b.tag_id = #{id}")
	List<Blogs> selectBlogsByTagId(String id);

}
