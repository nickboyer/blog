/*
 * Copyright 2014 Buyforyou.cn All rights reserved
 * 
 * @author Kang.Y
 * 
 * @mail
 * 
 * @createtime 2018年1月3日 下午11:10:03
 */
package cn.nickboyer.blog.web.cloud;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @title
 * @description
 * @since JDK1.8
 */
@FeignClient(value = "blog-server")
public interface Test {

	@RequestMapping("/hi")
	String test(@RequestParam("name") String name);
}
