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
import cn.nickboyer.blog.util.DigestUtil;
import cn.nickboyer.blog.util.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

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

    /**
     * 获取accessToken
     *
     * @return
     */
    private String getAccessToken() {
        String accessTokenStr = redis.opsForValue().get(Const.REDIS_WECHAT_ACCESS_TOKEN);
        if (StringUtils.isNotEmpty(accessTokenStr)) {
            return JSON.parseObject(accessTokenStr, JSONObject.class).getString("access_token");
        }
        String requestUrl = String.format(accessTokenUrl, appId, appSecret);
        JSONObject rsp = HttpUtil.doGet(requestUrl);
        redis.opsForValue().set(Const.REDIS_WECHAT_ACCESS_TOKEN, JSON.toJSONString(rsp), rsp.getLong("expires_in"), TimeUnit.SECONDS);
        return rsp.getString("access_token");
    }

    /**
     * 获取jsApiTicket
     *
     * @return
     */
    private String getJsApiTicket() {
        String jsApiTicketStr = redis.opsForValue().get(Const.REDIS_WECHAT_JS_API_TICKET);
        if (StringUtils.isNotEmpty(jsApiTicketStr)) {
            return JSON.parseObject(jsApiTicketStr, JSONObject.class).getString("ticket");
        }
        String requestUrl = String.format(apiTicketUrl, getAccessToken());
        JSONObject rsp = HttpUtil.doGet(requestUrl);
        redis.opsForValue().set(Const.REDIS_WECHAT_JS_API_TICKET, JSON.toJSONString(rsp), rsp.getLong("expires_in"), TimeUnit.SECONDS);
        return rsp.getString("ticket");
    }

    @Override
    public Map<String, String> getWechatParams(String url) {
        /**
         * 参数
         * url
         * jsapi_ticket
         * nonceStr
         * timestamp
         * signature
         * appid
         */
        String timestamp = getTimestamp();
        String nonceStr = getNonceStr();
        String str = "jsapi_ticket=" + getJsApiTicket() + "&noncestr=" + nonceStr + "&timestamp=" + timestamp + "&url=" + url;
        String signature = DigestUtil.digest(str);
        String jsApiTicket = getJsApiTicket();
        Map<String,String> params = new HashMap<>();
        params.put("url",url);
        params.put("timestamp",timestamp);
        params.put("nonceStr",nonceStr);
        params.put("signature",signature);
        params.put("jsApiTicket",jsApiTicket);
        params.put("appId",appId);
        return params;
    }

    /**
     * 获取nonceStr参数
     *
     * @return
     */
    private String getNonceStr() {
        return UUID.randomUUID().toString();
    }

    /**
     * 获取timestamp参数
     *
     * @return
     */
    private String getTimestamp() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }
}
