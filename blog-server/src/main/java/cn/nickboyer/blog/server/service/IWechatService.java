/*
 * Copyright 2017 nickboyer.cn All rights reserved
 *
 * @author Kang.Y
 *
 * @mail
 *
 * @createtime 2018/4/26 22:14
 */
package cn.nickboyer.blog.server.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @title
 * @description
 * @since JDK1.8
 */
public interface IWechatService {

    /**
     * 获取accessToken
     * @return
     */
    JSONObject getAccessToken();

    /**
     * 获取JsApiTIcket
     * @return
     */
    JSONObject getJsApiTicket();
}
