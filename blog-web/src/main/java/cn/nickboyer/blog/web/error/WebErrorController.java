/*
 * Copyright 2014-2018 buyforyou.cn.
 * All rights reserved.
 */
package cn.nickboyer.blog.web.error;

import cn.nickboyer.blog.common.Page;
import cn.nickboyer.blog.entry.Blogs;
import cn.nickboyer.blog.web.cloud.IBlogsService;
import cn.nickboyer.blog.web.cloud.IRedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.Map;

/**
 * @author Kang.Y
 * @since 1.8
 */
@Controller
@RequestMapping("/error")
public class WebErrorController implements ErrorController {

    public static final Logger logger = LoggerFactory.getLogger(WebErrorController.class);

    public static final String errorPath ="/error";

    private IBlogsService blogsService;

    private IRedisService redisService;

    private ErrorAttributes errorAttributes;

    public WebErrorController(ErrorAttributes errorAttributes,IBlogsService blogsService,IRedisService redisService) {
        this.errorAttributes = errorAttributes;
        this.blogsService = blogsService;
        this.redisService = redisService;
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping(produces = "text/html")
    public ModelAndView errorHtml(HttpServletRequest request, HttpServletResponse response) {
        // 跳转首页
        ModelAndView mv = new ModelAndView();
        mv.setViewName("404");
        // 获取字典数据
        Map<String, String> dicts = redisService.findAllDicts();
        mv.addObject("dicts", dicts);
        return mv;
    }

    @RequestMapping
    @ResponseBody
    public Object error(HttpServletRequest request) {
        return "{\"error\":\"error\"}";
    }

    protected HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request
                .getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        try {
            return HttpStatus.valueOf(statusCode);
        }
        catch (Exception ex) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }
}