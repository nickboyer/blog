/*
 * Copyright 2015 nickboyer.cn All rights reserved
 * 
 * @author Kang.Y
 * 
 * @mail
 * 
 * @createtime 2017年11月28日 下午1:17:03
 */
package cn.nickboyer.blog.server.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @title
 * @description
 * @author Kang.Y
 * @since JDK1.8
 */
public class BaseService {

	ObjectMapper mapper = new ObjectMapper();

	public Logger logger = LoggerFactory.getLogger(getClass());
}
