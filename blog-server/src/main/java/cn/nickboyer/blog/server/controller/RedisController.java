/*
 * Copyright 2014 Buyforyou.cn All rights reserved
 * 
 * @author Kang.Y
 * 
 * @mail
 * 
 * @createtime 2018年1月4日 上午12:04:52
 */
package cn.nickboyer.blog.server.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.nickboyer.blog.server.service.IRedisService;

/**
 * @title
 * @description
 * @since JDK1.8
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

	@Autowired
	private IRedisService redisService;

	@RequestMapping("/alldicts")
	public Map<String, String> findAllDicts() {
		return redisService.findAllDicts();
	}
}
