/*
 * Copyright 2015 nickboyer.cn All rights reserved
 *
 * @author Kang.Y
 *
 * @mail
 *
 * @createtime 2018年1月3日 下午1:28:01
 */
package cn.nickboyer.blog.web.cloud;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Kang.Y
 * @title
 * @description
 * @since JDK1.8
 */
@FeignClient(value = "blog-server")
@RequestMapping("/redis")
public interface IRedisService {

    /**
     * 获取所有的字典数据
     *
     * @return
     */
    @RequestMapping("/alldicts")
    public Map<String, String> findAllDicts();
    
}
