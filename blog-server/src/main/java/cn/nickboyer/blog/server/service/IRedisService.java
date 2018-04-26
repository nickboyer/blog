/*
 * Copyright 2015 nickboyer.cn All rights reserved
 *
 * @author Kang.Y
 *
 * @mail
 *
 * @createtime 2018年1月3日 下午1:28:01
 */
package cn.nickboyer.blog.server.service;

import java.util.Map;

/**
 * @author Kang.Y
 * @title
 * @description
 * @since JDK1.8
 */
public interface IRedisService {

    public Map<String, String> findAllDicts();

    /**
     * @authz Kang.Y
     * @createtime 2018年1月5日 下午12:25:03
     */
    public void delAllDicts();

    /**
     * @param name
     * @param value
     * @authz Kang.Y
     * @createtime 2018年1月5日 下午12:25:59
     */
    public void addDicts(String name, String value);

    /**
     * 获取所有的微信参数
     *
     * @return
     */
    Map<String, String> getWechatParams(String id);
}
