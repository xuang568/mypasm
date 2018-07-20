package com.dongzheng.pasm.core.common.utils;

import org.springframework.util.StringUtils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * <p>
 *
 * </p>
 *
 * @author xa
 * @since 2018-06-10
 */
public class MD5Utils {
    /**
     * 对字符串进行Md5加密
     *
     * @param input 原文
     * @return md5后的密文
     */
    public static String enCode(String input) {
        byte[] code = null;
        try {
            code = MessageDigest.getInstance("md5").digest(input.getBytes());
        } catch (NoSuchAlgorithmException e) {
            code = input.getBytes();
        }
        BigInteger bi = new BigInteger(code);
        return bi.abs().toString(32).toUpperCase();
    }

    /**
     * 对字符串进行Md5解密
     *
     * @param enCode 密文
     * @return 原文
     */
    public static String deCode(String enCode) {
        return null;
    }

    /**
     * 对字符串进行Md5加密
     *
     * @param input 原文
     * @param salt  随机数
     * @return string
     */
    public static String generatePasswordMD5(String input, String salt) {
        if (StringUtils.isEmpty(salt)) {
            salt = "";
        }
        return enCode(salt + enCode(input));
    }

    public static void main(String[] args) {
        System.out.println(enCode("111111"));
        ;
    }

}
