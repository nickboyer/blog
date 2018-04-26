/*
 * Copyright 2017 nickboyer.cn All rights reserved
 *
 * @author Kang.Y
 *
 * @mail
 *
 * @createtime 2018/4/26 22:14
 */
package cn.nickboyer.blog.server.service.impl;

import cn.nickboyer.blog.common.Const;
import cn.nickboyer.blog.server.service.IWechatService;
import cn.nickboyer.blog.util.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @title
 * @description
 * @since JDK1.8
 */
@Service
public class WechatServiceImpl implements IWechatService {

    @Autowired
    private StringRedisTemplate redis;

    @Value("${nickboyer.wechat.appId}")
    private String appId;

    @Value("${nickboyer.wechat.appSecret}")
    private String appSecret;

    @Value("${nickboyer.wechat.accessTokenUrl}")
    private String accessTokenUrl;

    @Value("${nickboyer.wechat.apiTicketUrl}")
    private String apiTicketUrl;


    @Override
    public JSONObject getAccessToken() {
        String accessTokenStr = redis.opsForValue().get(Const.REDIS_WECHAT_ACCESS_TOKEN);
        if (StringUtils.isNotEmpty(accessTokenStr)) {
            return JSON.parseObject(accessTokenStr, JSONObject.class);
        } else {
            String requestUrl = String.format(accessTokenUrl, appId, appSecret);
            JSONObject rsp = HttpUtil.doGet(requestUrl);
            redis.opsForValue().set(Const.REDIS_WECHAT_ACCESS_TOKEN, JSON.toJSONString(rsp));
            return rsp;
        }
    }

    @Override
    public JSONObject getJsApiTicket() {

        String requestUrl = String.format(apiTicketUrl, getAccessToken());
        return HttpUtil.doGet(requestUrl);
    }
}
