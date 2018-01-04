/*
 * Copyright 2014 Buyforyou.cn All rights reserved
 * 
 * @author Kang.Y
 * 
 * @mail
 * 
 * @createtime 2017年8月29日 下午1:36:50
 */
package cn.nickboyer.blog.web.configure;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @title
 * @description
 * @author Kang.Y
 * @since JDK1.8
 */
@Component
@Configuration
@ConfigurationProperties(prefix = "nickboyer", ignoreUnknownFields = true)
public class Properties {

}
