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

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @title
 * @description
 * @author Kang.Y
 * @since JDK1.8
 */
@Mapper
public interface CategorysMapper {

	/**
	 * @return
	 *
	 * @authz Kang.Y
	 * @createtime 2018年1月5日 下午1:21:56
	 */
	@Select("select count(1) from categorys")
	int count();

}
