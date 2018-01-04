/*
 * Copyright 2015 nickboyer.cn All rights reserved
 * 
 * @author Kang.Y
 * 
 * @mail
 * 
 * @createtime 2018年1月3日 上午11:58:31
 */
package cn.nickboyer.blog.entry;

import java.io.Serializable;
import java.util.Date;

/**
 * @title
 * @description
 * @author Kang.Y
 * @since JDK1.8
 */
public class Tags implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String name;

	private String color;

	private String size;

	private Date createTime;

	private Date updateTime;

	/**
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id to set id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name to set name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color to set color
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return size
	 */
	public String getSize() {
		return size;
	}

	/**
	 * @param size to set size
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * @return createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime to set createTime
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return updateTime
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * @param updateTime to set updateTime
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
