/*
 * Copyright 2015 nickboyer.cn All rights reserved
 *
 * @author Kang.Y
 *
 * @mail
 *
 * @createtime 2018年1月3日 下午1:28:26
 */
package cn.nickboyer.blog.server.service.impl;

import java.util.Map;

import cn.nickboyer.blog.server.service.IWechatService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import cn.nickboyer.blog.common.Const;
import cn.nickboyer.blog.server.service.BaseService;
import cn.nickboyer.blog.server.service.IRedisService;

/**
 * @author Kang.Y
 * @title
 * @description
 * @since JDK1.8
 */
@Service
public class RedisServiceImpl extends BaseService implements IRedisService {

    @Autowired
    private StringRedisTemplate redis;
    @Autowired
    private IWechatService wechatService;

    /**
     * （no Javadoc）
     *
     * @see cn.nickboyer.blog.api.service.IRedisService#findAllDicts()
     */
    @Override
    public Map<String, String> findAllDicts() {

        BoundHashOperations<String, String, String> ops = redis.boundHashOps(Const.REDIS_DICTS);
        Map<String, String> entries = ops.entries();
        return entries;
    }

    /**
     * （no Javadoc）
     *
     * @see cn.nickboyer.blog.server.service.IRedisService#delAllDicts()
     */
    @Override
    public void delAllDicts() {

        redis.delete(Const.REDIS_DICTS);
    }

    /**
     * （no Javadoc）
     *
     * @see cn.nickboyer.blog.server.service.IRedisService#addDicts(java.lang.String, java.lang.String)
     */
    @Override
    public void addDicts(String name, String value) {

        BoundHashOperations<String, String, String> ops = redis.boundHashOps(Const.REDIS_DICTS);
        ops.put(name, value);
    }


}
