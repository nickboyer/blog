/*
 * Copyright 2014 Buyforyou.cn All rights reserved
 * 
 * @author Kang.Y
 * 
 * @mail
 * 
 * @createtime 2017年8月29日 下午1:38:36
 */
package cn.nickboyer.blog.web.configure;

import org.springframework.stereotype.Component;

/**
 * @title
 * @description
 * @author Kang.Y
 * @since JDK1.8
 */
@Component
public class PropertiesUtil {

	private static Properties pro;

	private PropertiesUtil(Properties pro) {

		this.pro = pro;
	}

	/**
	 * 静态方法获取自定义配置文件
	 * 
	 * @return pro 配置文件对象
	 *
	 * @authz Kang.Y
	 * @createtime 2017年8月29日 下午1:40:05
	 */
	public static Properties intance() {

		return pro;
	}
}
