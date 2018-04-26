/*
 * Copyright 2017 nickboyer.cn All rights reserved
 *
 * @author Kang.Y
 *
 * @mail
 *
 * @createtime 2018/4/26 21:52
 */
package cn.nickboyer.blog.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @title
 * @description
 * @since JDK1.8
 */
public class HttpUtil {

    /**
     * 发送get请求
     * @param url
     * @return
     */
    public static JSONObject doGet(String url){

        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        JSONObject rsp = null;
        try {
            //创建GET请求
            HttpGet httpGet = new HttpGet(url);
            //执行Get请求
            response = httpClient.execute(httpGet);
            //得到响应
            HttpEntity entry = response.getEntity();
            //转换为map
            String responseStr = EntityUtils.toString(entry);
            rsp = JSON.parseObject(responseStr);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return rsp;
    }
}
