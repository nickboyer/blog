/*
 * Copyright 2015 nickboyer.cn All rights reserved
 * 
 * @author Kang.Y
 * 
 * @mail
 * 
 * @createtime 2018年1月5日 下午1:20:21
 */
package cn.nickboyer.blog.server.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import cn.nickboyer.blog.entry.Categories;

/**
 * @title
 * @description
 * @author Kang.Y
 * @since JDK1.8
 */
@Mapper
public interface CategoriesMapper {

	/**
	 * @return
	 *
	 * @authz Kang.Y
	 * @createtime 2018年1月5日 下午1:21:56
	 */
	@Select("select count(1) from categories")
	int count();

	/**
	 * 
	 *
	 * @return
	 * @authz Kang.Y
	 * @createtime 2018年1月7日 下午4:12:02
	 */
	@Select("select a.id,a.name,a.create_time,a.update_time,(select count(1) from blogs where category_id = a.id) blog_count from categories a ;")
	List<Categories> selectAll();

	/**
	 * @param id
	 * @return
	 *
	 * @authz Kang.Y
	 * @createtime 2018年1月7日 下午4:14:28
	 */
	@Select("select * from categories where id = #{id}")
	Categories selectById(String id);

}
