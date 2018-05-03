/*
 * Copyright 2014-2018 buyforyou.cn.
 * All rights reserved.
 */
package cn.nickboyer.blog.web.cloud;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author Kang.Y
 * @since 1.8
 */
@FeignClient(value = "blog-server")
@RequestMapping("/wechat")
public interface IWechatService {

    /**
     * 获取微信参数
     * @return
     */
    @RequestMapping("/params")
    public Map<String,String> getWechatParams(@RequestParam("url")String url);
}
