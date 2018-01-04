/*
 * Copyright 2015 nickboyer.cn All rights reserved
 * 
 * @author Kang.Y
 * 
 * @mail
 * 
 * @createtime 2018年1月3日 上午11:50:11
 */
package cn.nickboyer.blog.entry;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @title
 * @description
 * @author Kang.Y
 * @since JDK1.8
 */
public class Blogs implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String header;

	private byte[] intro;

	private String introStr;

	private byte[] content;

	private String contentStr;

	private Integer categoryId;

	private String categoryName;

	private Integer watch;

	private Date createTime;

	private Date updateTime;

	private List<Tags> tags;

	/**
	 * @return tags
	 */
	public List<Tags> getTags() {
		return tags;
	}

	/**
	 * @param tags to set tags
	 */
	public void setTags(List<Tags> tags) {
		this.tags = tags;
	}

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
	 * @return header
	 */
	public String getHeader() {
		return header;
	}

	/**
	 * @param header to set header
	 */
	public void setHeader(String header) {
		this.header = header;
	}

	/**
	 * @return intro
	 */
	public byte[] getIntro() {
		return intro;
	}

	/**
	 * @param intro to set intro
	 */
	public void setIntro(byte[] intro) {
		this.intro = intro;
		this.introStr = intro == null ? null : new String(intro);
	}

	/**
	 * @return introStr
	 */
	public String getIntroStr() {
		return introStr;
	}

	/**
	 * @param introStr to set introStr
	 */
	public void setIntroStr(String introStr) {
		this.introStr = introStr;
	}

	/**
	 * @return content
	 */
	public byte[] getContent() {
		return content;
	}

	/**
	 * @param content to set content
	 */
	public void setContent(byte[] content) {
		this.content = content;
		this.contentStr = content == null ? null : new String(content);
	}

	/**
	 * @return contentStr
	 */
	public String getContentStr() {
		return contentStr;
	}

	/**
	 * @param contentStr to set contentStr
	 */
	public void setContentStr(String contentStr) {
		this.contentStr = contentStr;
	}

	/**
	 * @return categoryId
	 */
	public Integer getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId to set categoryId
	 */
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * @return categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * @param categoryName to set categoryName
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * @return watch
	 */
	public Integer getWatch() {
		return watch;
	}

	/**
	 * @param watch to set watch
	 */
	public void setWatch(Integer watch) {
		this.watch = watch;
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
