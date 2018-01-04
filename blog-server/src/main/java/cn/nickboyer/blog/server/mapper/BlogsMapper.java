/*
 * Copyright 2015 nickboyer.cn All rights reserved
 * 
 * @author Kang.Y
 * 
 * @mail
 * 
 * @createtime 2018年1月3日 下午12:07:48
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
public interface BlogsMapper {

	/**
	 * @return
	 *
	 * @authz Kang.Y
	 * @createtime 2018年1月3日 下午12:12:51
	 */
	@Select("select * from blogs order by id desc")
	List<Blogs> selectList();

	/**
	 * @param id
	 * @return
	 *
	 * @authz Kang.Y
	 * @createtime 2018年1月4日 下午1:16:14
	 */
	@Select("select * from blogs where id = #{id}")
	Blogs selectById(String id);

	/**
	 * @param id
	 * @return
	 *
	 * @authz Kang.Y
	 * @createtime 2018年1月4日 下午3:59:22
	 */
	@Select("select a.id,a.name from tags a,blog_tag_relation b where a.id = b.tag_id and b.blog_id = #{id}")
	List<Tags> selectTagsById(String id);

	/**
	 * @param id
	 * @return
	 *
	 * @authz Kang.Y
	 * @createtime 2018年1月4日 下午10:17:36
	 */
	@Select("select id,header from blogs where id < #{id} order by id desc limit 1")
	Blogs selectPrev(String id);

	/**
	 * @param id
	 * @return
	 *
	 * @authz Kang.Y
	 * @createtime 2018年1月4日 下午10:17:41
	 */
	@Select("select id,header from blogs where id > #{id} order by id asc limit 1")
	Blogs selectNext(String id);

}
