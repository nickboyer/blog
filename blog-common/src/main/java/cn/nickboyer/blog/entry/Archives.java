/*
 * Copyright 2014 Buyforyou.cn All rights reserved
 * 
 * @author Kang.Y
 * 
 * @mail
 * 
 * @createtime 2018年1月5日 下午9:07:48
 */
package cn.nickboyer.blog.entry;

import java.io.Serializable;
import java.util.List;

/**
 * @title
 * @description
 * @since JDK1.8
 */
public class Archives implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String time;

	private List<Blogs> list;

	public Archives() {

	}

	public Archives(String time, List<Blogs> list) {

		this.time = time;
		this.list = list;
	}

	/**
	 * @return time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @param time 要设置的 time
	 */
	public void setTime(String time) {
		this.time = time;
	}

	/**
	 * @return list
	 */
	public List<Blogs> getList() {
		return list;
	}

	/**
	 * @param list 要设置的 list
	 */
	public void setList(List<Blogs> list) {
		this.list = list;
	}

}
