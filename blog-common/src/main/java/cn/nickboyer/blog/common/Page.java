/*
 * Copyright 2015 nickboyer.cn All rights reserved
 * 
 * @author Kang.Y
 * 
 * @mail
 * 
 * @createtime 2018年1月4日 上午10:13:13
 */
package cn.nickboyer.blog.common;

import java.io.Serializable;

/**
 * @title
 * @description
 * @author Kang.Y
 * @since JDK1.8
 */
public class Page<E> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Page() {

	}

	public Page(com.github.pagehelper.Page<E> page) {

		this.page = page;
		this.pageNum = page.getPageNum();
		this.pageSize = page.getPageSize();
		this.startRow = page.getStartRow();
		this.endRow = page.getEndRow();
		this.total = page.getTotal();
		this.pages = page.getPages();
		this.count = page.isCount();
		this.reasonable = page.getReasonable();
		this.pageSizeZero = page.getPageSizeZero();
		this.countColumn = page.getCountColumn();
		this.orderBy = page.getOrderBy();
		this.orderByOnly = page.isOrderByOnly();
	}

	private com.github.pagehelper.Page<E> page;

	/**
	 * 页码，从1开始
	 */
	private int pageNum;
	/**
	 * 页面大小
	 */
	private int pageSize;
	/**
	 * 起始行
	 */
	private int startRow;
	/**
	 * 末行
	 */
	private int endRow;
	/**
	 * 总数
	 */
	private long total;
	/**
	 * 总页数
	 */
	private int pages;
	/**
	 * 包含count查询
	 */
	private boolean count = true;
	/**
	 * 分页合理化
	 */
	private Boolean reasonable;
	/**
	 * 当设置为true的时候，如果pagesize设置为0（或RowBounds的limit=0），就不执行分页，返回全部结果
	 */
	private Boolean pageSizeZero;
	/**
	 * 进行count查询的列名
	 */
	private String countColumn;
	/**
	 * 排序
	 */
	private String orderBy;
	/**
	 * 只增加排序
	 */
	private boolean orderByOnly;

	/**
	 * @return pageNum
	 */
	public int getPageNum() {
		return pageNum;
	}

	/**
	 * @param pageNum to set pageNum
	 */
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	/**
	 * @return pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize to set pageSize
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return startRow
	 */
	public int getStartRow() {
		return startRow;
	}

	/**
	 * @param startRow to set startRow
	 */
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	/**
	 * @return endRow
	 */
	public int getEndRow() {
		return endRow;
	}

	/**
	 * @param endRow to set endRow
	 */
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	/**
	 * @return total
	 */
	public long getTotal() {
		return total;
	}

	/**
	 * @param total to set total
	 */
	public void setTotal(long total) {
		this.total = total;
	}

	/**
	 * @return pages
	 */
	public int getPages() {
		return pages;
	}

	/**
	 * @param pages to set pages
	 */
	public void setPages(int pages) {
		this.pages = pages;
	}

	/**
	 * @return count
	 */
	public boolean isCount() {
		return count;
	}

	/**
	 * @param count to set count
	 */
	public void setCount(boolean count) {
		this.count = count;
	}

	/**
	 * @return reasonable
	 */
	public Boolean getReasonable() {
		return reasonable;
	}

	/**
	 * @param reasonable to set reasonable
	 */
	public void setReasonable(Boolean reasonable) {
		this.reasonable = reasonable;
	}

	/**
	 * @return pageSizeZero
	 */
	public Boolean getPageSizeZero() {
		return pageSizeZero;
	}

	/**
	 * @param pageSizeZero to set pageSizeZero
	 */
	public void setPageSizeZero(Boolean pageSizeZero) {
		this.pageSizeZero = pageSizeZero;
	}

	/**
	 * @return countColumn
	 */
	public String getCountColumn() {
		return countColumn;
	}

	/**
	 * @param countColumn to set countColumn
	 */
	public void setCountColumn(String countColumn) {
		this.countColumn = countColumn;
	}

	/**
	 * @return orderBy
	 */
	public String getOrderBy() {
		return orderBy;
	}

	/**
	 * @param orderBy to set orderBy
	 */
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	/**
	 * @return orderByOnly
	 */
	public boolean isOrderByOnly() {
		return orderByOnly;
	}

	/**
	 * @param orderByOnly to set orderByOnly
	 */
	public void setOrderByOnly(boolean orderByOnly) {
		this.orderByOnly = orderByOnly;
	}

	/**
	 * @return page
	 */
	public com.github.pagehelper.Page<E> getPage() {
		return page;
	}

	/**
	 * @param page to set page
	 */
	public void setPage(com.github.pagehelper.Page<E> page) {
		this.page = page;
	}

}
