/*
 * Copyright 2014 Buyforyou.cn All rights reserved
 * 
 * @author Kang.Y
 * 
 * @mail
 * 
 * @createtime 2017年8月14日 下午1:42:52
 */
package cn.nickboyer.blog.biz;

/**
 * @title
 * @description
 * @author Kang.Y
 * @since JDK1.8
 */
public class BizException extends Exception {

	private static final long serialVersionUID = -1995283733346569792L;

	public String messageCode;

	public BizException() {

		super();
	}

	public BizException(String message) {

		super(message);
	}

	public BizException(String messageCode, String message) {

		super(message);
		this.messageCode = messageCode;
	}

	/**
	 * @param messageCode 异常代码
	 * @param message 异常信息
	 * @param e 异常
	 */
	public BizException(String messageCode, String message, Throwable e) {

		super(message, e);
		this.messageCode = messageCode;
	}

	/**
	 * @param messageCode 异常代码
	 * @param message 异常信息
	 * @param args 参数
	 * 
	 *        <pre>
	 *        new BizException("PR0000", "业务异常，异常信息%s", "数据库操作异常");
	 *        </pre>
	 */
	public BizException(String messageCode, String message, Object... args) {

		super(String.format(message, args));
		this.messageCode = messageCode;
	}

	/**
	 * @param messageCode 异常代码
	 * @param message 异常信息
	 * @param e 异常
	 * @param args 参数
	 * 
	 *        <pre>
	 *        new BizException("PR0000", "业务异常，异常信息%s", e, "数据库操作异常");
	 *        </pre>
	 */
	public BizException(String messageCode, String message, Throwable e, Object... args) {

		super(String.format(message, args), e);
		this.messageCode = messageCode;

	}

}