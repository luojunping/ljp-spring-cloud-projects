package com.ljp.test.controller.md5;

import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * @author 罗俊平
 * @email 591402399@qq.com
 * @date 2021/1/23
 * @since 1.0.0
 **/
public class MD5Test {

    private static final String PASSWORD = "中国加油！！！世界加油！！！";

    public static void main(String[] args) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("md5");
        byte[] digest = md5.digest(PASSWORD.getBytes(StandardCharsets.UTF_8));
        String jdkMsg = Base64.getEncoder().encodeToString(digest);
        System.out.println("jdkMsg = " + jdkMsg);
        System.out.println("jdkMsg.length() = " + jdkMsg.length());
        String springMsg = DigestUtils.md5DigestAsHex(PASSWORD.getBytes(StandardCharsets.UTF_8));
        System.out.println("springMsg = " + springMsg);
        System.out.println("springMsg.length() = " + springMsg.length());
        String codecMsg = org.apache.commons.codec.digest.DigestUtils.md5Hex(PASSWORD.getBytes(StandardCharsets.UTF_8));
        System.out.println("codecMsg = " + codecMsg);
        System.out.println("codecMsg.length() = " + codecMsg.length());
    }

}
