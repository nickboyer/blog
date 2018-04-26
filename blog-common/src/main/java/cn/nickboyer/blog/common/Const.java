/*
 * Copyright 2014 Buyforyou.cn All rights reserved
 * 
 * @author Kang.Y
 * 
 * @mail
 * 
 * @createtime 2017年9月4日 下午5:18:32
 */
package cn.nickboyer.blog.common;

/**
 * @title
 * @description
 * @author Kang.Y
 * @since JDK1.8
 */
public class Const {

	/** 存入session中的验证码code */
	public static final String VERIFY_CODE = "verifyCode";
	public static final String REDIS_DICTS = "nickboyer:dict";
	public static final String SOLR_COLLECTION_NICKBOYER = "nickboyer";
	public static final String NICKBOYER_LOCATION = "http://www.nickboyer.cn/static/blog/";
	public static final Integer NICKBOYER_SOLR_ROWS = 100;
	public static final String REDIS_WECHAT_ACCESS_TOKEN = "nickboyer:wechat:access_token";
	public static final String REDIS_WECHAT_JS_API_TICKET = "nickboyer:wechat:js_api_ticket";
}
