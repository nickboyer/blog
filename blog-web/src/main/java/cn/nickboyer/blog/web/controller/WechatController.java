/*
 * Copyright 2014-2018 buyforyou.cn.
 * All rights reserved.
 */
package cn.nickboyer.blog.web.controller;

import cn.nickboyer.blog.web.cloud.IWechatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author Kang.Y
 * @since 1.8
 */
@Controller
public class WechatController extends BaseComponent {

    @Autowired
    private IWechatService wechatService;

    @RequestMapping("/wechatParams")
    @ResponseBody
    public Map<String,String> getWechatParams(String url){
        return wechatService.getWechatParams(url);
    }
}
