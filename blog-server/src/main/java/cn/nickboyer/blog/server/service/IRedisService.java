/*
 * Copyright 2015 nickboyer.cn All rights reserved
 * 
 * @author Kang.Y
 * 
 * @mail
 * 
 * @createtime 2018年1月3日 下午1:28:01
 */
package cn.nickboyer.blog.server.service;

import java.util.Map;

/**
 * @title
 * @description
 * @author Kang.Y
 * @since JDK1.8
 */
public interface IRedisService {

	public Map<String, String> findAllDicts();
}
