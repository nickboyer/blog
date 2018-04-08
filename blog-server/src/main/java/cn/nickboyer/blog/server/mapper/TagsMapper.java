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

import cn.nickboyer.blog.entry.BlogTagRelation;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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

	/**
	 * @return
	 *
	 * @authz Kang.Y
	 * @createtime 2018年1月5日 下午1:22:20
	 */
	@Select("select count(1) from tags")
	int count();

	/**
	 *
	 * @param list
	 */
	@Insert({ "<script>","insert into blog_tag_relation (blog_id,tag_id) values ",
			"<foreach item='item' collection='list' separator=',' open='' close=''>",
			"(#{item.blogId},#{item.tagId})",
			"</foreach>", "</script>" })
    void insertRelation(@Param("list")List<BlogTagRelation> list);
}
