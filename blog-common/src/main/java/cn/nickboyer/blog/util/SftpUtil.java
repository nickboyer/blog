/*
 * Copyright 2014 Buyforyou.cn All rights reserved
 * 
 * @author Kang.Y
 * 
 * @mail
 * 
 * @createtime 2017年12月15日 下午11:22:48
 */
package cn.nickboyer.blog.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

/**
 * @title
 * @description
 * @since JDK1.8
 */
public class SftpUtil {

	public static final String host = "39.106.24.47";
	public static final int port = 22;
	public static final String username = "mysftp";
	public static final String pwd = "mysftp";
	public static final int timeout = 30000;
	public static final String path = "upload/static/";

	public static void upload(InputStream is, String dst) throws JSchException, SftpException {

		Session session = null;
		Channel channel = null;
		JSch jsch = new JSch(); // 创建JSch对象
		session = jsch.getSession(username, host, port); // 根据用户名，主机ip，端口获取一个Session对象
		if (pwd != null) {
			session.setPassword(pwd); // 设置密码
		}
		Properties config = new Properties();
		config.put("StrictHostKeyChecking", "no");
		session.setConfig(config); // 为Session对象设置properties
		session.setTimeout(timeout); // 设置timeout时间
		session.connect(); // 通过Session建立链接
		channel = session.openChannel("sftp"); // 打开SFTP通道
		channel.connect(); // 建立SFTP通道的连接
		((ChannelSftp) channel).put(is, path + dst);
		if (channel != null) {
			channel.disconnect();
		}
		if (session != null) {
			session.disconnect();
		}
	}

	public static void main(String[] args) throws Exception {
		upload(new FileInputStream(new File("e://abc.txt")), "blog/abc.txt");
	}
}
