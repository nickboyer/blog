/*
 * Copyright 2014-2018 buyforyou.cn.
 * All rights reserved.
 */
package cn.nickboyer.blog.server.controller;

import cn.nickboyer.blog.server.service.IWechatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Kang.Y
 * @since 1.8
 */
@RestController
@RequestMapping("/wechat")
public class WechatController {

    @Autowired
    private IWechatService wechatService;

    @RequestMapping("/params")
    public Map<String,String> getWechatParams(@RequestParam("url")String url){
        return wechatService.getWechatParams(url);
    }
}
