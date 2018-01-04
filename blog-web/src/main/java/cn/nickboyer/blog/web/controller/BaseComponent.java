/*
 * Copyright 2014 Buyforyou.cn All rights reserved
 * 
 * @author Kang.Y
 * 
 * @mail
 * 
 * @createtime 2017年11月10日 下午2:50:02
 */
package cn.nickboyer.blog.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import cn.nickboyer.blog.web.configure.Properties;

/**
 * @title
 * @description
 * @author Kang.Y
 * @since JDK1.8
 */
@Component
public class BaseComponent {

	@Autowired
	public Properties pro;

	public Logger logger = LoggerFactory.getLogger(getClass());

	public ObjectMapper mapper = new ObjectMapper();

}
