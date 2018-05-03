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
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * @title
 * @description
 * @since JDK1.8
 */
public class HttpUtil {

    /**
     * 发送get请求
     *
     * @param url
     * @return
     */
    public static JSONObject doGet(String url) {
        JSONObject rsp = null;
        try {
            SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(null, new TrustStrategy() {
                @Override
                public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                    return true;
                }
            }).build();
            CloseableHttpClient httpClient = HttpClients.custom().setSSLContext(sslContext).setSSLHostnameVerifier(new NoopHostnameVerifier()).build();
            CloseableHttpResponse response = null;
            //创建GET请求
            HttpGet httpGet = new HttpGet(url);
            //执行Get请求
            response = httpClient.execute(httpGet);
            //得到响应
            HttpEntity entry = response.getEntity();
            //转换为map
            String responseStr = EntityUtils.toString(entry);
            rsp = JSON.parseObject(responseStr);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return rsp;
    }


    public static void main(String[] args) throws Exception {
        doGet("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxb70aef71568ff2f7&secret=f031a5f96c1b3e18260b0f437908b31b");
    }
}
