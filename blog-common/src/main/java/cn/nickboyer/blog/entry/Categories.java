/*
 * Copyright 2014 Buyforyou.cn All rights reserved
 * 
 * @author Kang.Y
 * 
 * @mail
 * 
 * @createtime 2018年1月7日 下午3:39:35
 */
package cn.nickboyer.blog.entry;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @title
 * @description
 * @since JDK1.8
 */
public class Categories implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String name;

	private Date createTime;

	private Date updateTime;

	private List<Archives> archives;

	private Integer blogCount;

	/**
	 * @return blogCount
	 */
	public Integer getBlogCount() {
		return blogCount;
	}

	/**
	 * @param blogCount 要设置的 blogCount
	 */
	public void setBlogCount(Integer blogCount) {
		this.blogCount = blogCount;
	}

	/**
	 * @return archives
	 */
	public List<Archives> getArchives() {
		return archives;
	}

	/**
	 * @param archives 要设置的 archives
	 */
	public void setArchives(List<Archives> archives) {
		this.archives = archives;
	}

	/**
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id 要设置的 id
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
	 * @param name 要设置的 name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime 要设置的 createTime
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
	 * @param updateTime 要设置的 updateTime
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
