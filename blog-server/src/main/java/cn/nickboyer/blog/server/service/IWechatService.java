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

import java.util.Map;

/**
 * @title
 * @description
 * @since JDK1.8
 */
public interface IWechatService {

    /**
     * 获取wechat参数
     * @param url
     * @return
     */
    Map<String,String> getWechatParams(String url);
}
