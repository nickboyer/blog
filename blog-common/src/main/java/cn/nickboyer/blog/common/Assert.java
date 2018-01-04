/*
 * Copyright 2014 Buyforyou.cn All rights reserved
 * 
 * @author Kang.Y
 * 
 * @mail
 * 
 * @createtime 2017年8月29日 下午12:07:39
 */
package cn.nickboyer.blog.common;

import cn.nickboyer.blog.biz.BizException;

/**
 * @title
 * @description
 * @author Kang.Y
 * @since JDK1.8
 */
public class Assert {

	/**
	 * 字符串非空校验
	 * 
	 * @param str 被校验字符串
	 * @param errCode 错误代码
	 * @param errMsg 错误信息
	 * @param args 参数
	 * @throws BizException
	 *
	 * @authz Kang.Y
	 * @createtime 2017年8月29日 下午1:34:27
	 */
	public static void notNull(String str, String errCode, String errMsg, String... args) throws BizException {

		if (str == null || "".equals(str)) {

			throw new BizException(errCode, errMsg, args);
		}
	}

	/**
	 * 对象非空校验
	 * 
	 * @param obj 被校验对象
	 * @param errCode 错误代码
	 * @param errMsg 错误信息
	 * @param args 参数
	 * @throws BizException
	 *
	 * @authz Kang.Y
	 * @createtime 2017年8月29日 下午1:34:53
	 */
	public static void notNull(Object obj, String errCode, String errMsg, String... args) throws BizException {

		if (obj == null) {

			throw new BizException(errCode, errMsg, args);
		}
	}
}
