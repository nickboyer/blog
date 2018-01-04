/*
 * Copyright 2014 Buyforyou.cn All rights reserved
 * 
 * @author Kang.Y
 * 
 * @mail
 * 
 * @createtime 2017年12月10日 下午12:07:12
 */
package cn.nickboyer.blog.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @title
 * @description
 * @since JDK1.8
 */
public class DateUtil {

	private static final String YYYY_MM = "yyyy-MM";

	/**
	 * 时间格式化
	 * 
	 * @param date
	 * @return
	 *
	 * @authz Kang.Y
	 * @createtime 2017年12月10日 下午12:08:48
	 */
	public static String toYYYY_MM(Date date) {

		SimpleDateFormat format = new SimpleDateFormat(YYYY_MM);
		return format.format(date);
	}

}
