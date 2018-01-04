/*
 * Copyright 2014 Buyforyou.cn All rights reserved
 * 
 * @author Kang.Y
 * 
 * @mail
 * 
 * @createtime 2017年8月30日 下午2:22:02
 */
package cn.nickboyer.blog.util;

import java.math.BigInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 权限工具类
 * 
 * @title
 * @description
 * @author Kang.Y
 * @since JDK1.8
 */
public class RightsUtil {

	private static final Logger logger = LoggerFactory.getLogger(RightsUtil.class);

	/**
	 * 计算权限
	 * 
	 * @param rights
	 * @return
	 *
	 * @authz Kang.Y
	 * @createtime 2017年8月30日 下午2:25:17
	 */
	public static String sumRights(int[] rights) {

		BigInteger num = new BigInteger("0");
		for (int i : rights) {

			num = num.setBit(i);
		}

		return num.toString();
	}

	/**
	 * 计算权限
	 * 
	 * @param rights
	 * @return
	 *
	 * @authz Kang.Y
	 * @createtime 2017年8月30日 下午2:26:43
	 */
	public static String sumRights(String[] rights) {

		BigInteger num = new BigInteger("0");
		for (String i : rights) {

			num = num.setBit(Integer.valueOf(i));
		}
		return num.toString();
	}

	/**
	 * 测试权限
	 * 
	 * @param sum 权限和
	 * @param rights 单个
	 * @return
	 *
	 * @authz Kang.Y
	 * @createtime 2017年8月30日 下午2:27:50
	 */
	public static Boolean testRights(BigInteger sum, int rights) {

		try {
			return sum.testBit(rights);

		} catch (Exception e) {

			logger.error("权限校验异常", e);
			return false;
		}
	}

	/**
	 * 测试权限
	 * 
	 * @param sum 权限和
	 * @param rights 单个
	 * @return
	 *
	 * @authz Kang.Y
	 * @createtime 2017年8月30日 下午2:31:13
	 */
	public static Boolean testRights(String sum, String rights) {

		try {

			return new BigInteger(sum).testBit(Integer.valueOf(rights));
		} catch (Exception e) {

			logger.error("权限校验异常", e);
			return false;
		}
	}

	public static void main(String[] args) {
		String sumRights = sumRights(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11" });
		System.out.println(sumRights);
	}
}
