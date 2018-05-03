/*
 * Copyright 2014-2018 buyforyou.cn.
 * All rights reserved.
 */
package cn.nickboyer.blog.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

/**
 * @author Kang.Y
 * @since 1.8
 */
public class DigestUtil {

    private static MessageDigest crypt;

    static {
        try {
            crypt = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    /**
     * 摘要
     *
     * @param target
     * @return
     */
    public static String digest(String target) {
        crypt.reset();
        crypt.update(target.getBytes());
        return byteToHex(crypt.digest());
    }

    private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash) {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }
}
