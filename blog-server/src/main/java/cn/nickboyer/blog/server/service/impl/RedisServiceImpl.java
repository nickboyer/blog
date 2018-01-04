/*
 * Copyright 2015 nickboyer.cn All rights reserved
 * 
 * @author Kang.Y
 * 
 * @mail
 * 
 * @createtime 2018年1月3日 下午1:28:26
 */
package cn.nickboyer.blog.server.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import cn.nickboyer.blog.common.Const;
import cn.nickboyer.blog.server.service.BaseService;
import cn.nickboyer.blog.server.service.IRedisService;

/**
 * @title
 * @description
 * @author Kang.Y
 * @since JDK1.8
 */
@Service
public class RedisServiceImpl extends BaseService implements IRedisService {

	@Autowired
	private StringRedisTemplate redis;

	/**
	 * （no Javadoc）
	 * 
	 * @see cn.nickboyer.blog.api.service.IRedisService#findAllDicts()
	 */
	@Override
	public Map<String, String> findAllDicts() {

		BoundHashOperations<String, String, String> ops = redis.boundHashOps(Const.REDIS_DICTS);
		Map<String, String> entries = ops.entries();
		return entries;
	}
}
