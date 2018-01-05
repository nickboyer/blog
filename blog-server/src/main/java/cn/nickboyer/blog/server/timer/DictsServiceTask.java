/*
 * Copyright 2015 nickboyer.cn All rights reserved
 * 
 * @author Kang.Y
 * 
 * @mail
 * 
 * @createtime 2018年1月5日 下午12:17:01
 */
package cn.nickboyer.blog.server.timer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import cn.nickboyer.blog.entry.Dicts;
import cn.nickboyer.blog.server.mapper.BlogsMapper;
import cn.nickboyer.blog.server.mapper.CategorysMapper;
import cn.nickboyer.blog.server.mapper.DictsMapper;
import cn.nickboyer.blog.server.mapper.TagsMapper;
import cn.nickboyer.blog.server.service.IRedisService;

/**
 * @title
 * @description
 * @author Kang.Y
 * @since JDK1.8
 */
@Component
public class DictsServiceTask {

	@Autowired
	private DictsMapper dictsMapper;
	@Autowired
	private TagsMapper tagsMapper;
	@Autowired
	private BlogsMapper blogsMapper;
	@Autowired
	private CategorysMapper categorysMapper;
	@Autowired
	private IRedisService redisService;

	@Scheduled(fixedDelayString = "${nickboyer.task.dicts}")
	public void execute() {

		// 1.更新Redis数据字典
		// 1.1. 获取所有字典数据
		List<Dicts> dicts = dictsMapper.selectAll();
		// 1.2. 更新redis数据
		// redisService.delAllDicts();
		for (Dicts dict : dicts) {

			redisService.addDicts(dict.getName(), dict.getValue());
		}
		// 1.3. 统计日志、分类、标签数量
		int blogsCount = blogsMapper.count();
		int categorysCount = categorysMapper.count();
		int tagsCount = tagsMapper.count();
		redisService.addDicts("blogsCount", blogsCount + "");
		redisService.addDicts("categorysCount", categorysCount + "");
		redisService.addDicts("tagsCount", tagsCount + "");

	}
}
