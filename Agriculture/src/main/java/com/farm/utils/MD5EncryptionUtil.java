package com.farm.utils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * @Author: Rain
 * @Description: md5加密工具类
 * @Date: Created on 2018/11/1 15:55
 */
public class MD5EncryptionUtil {
    protected static char          hexDigits[]   = { '0', '1', '2', '3', '4', '5', '6',  '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
    protected static MessageDigest messageDigest = null;
    /**
     * messageDigest初始化
     */
    static {
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            System.err.println("MD5EncryptionUtil messageDigest初始化失败");
            e.printStackTrace();
        }
    }
    /**
     * 加密byte数组，返回加密后的16进制字符串
     * @param bytes
     * @return
     */
    private static String encryptByteArray(byte[] bytes) {
        messageDigest.update(bytes);
        return ParseUtil.byteArrayToHexString(messageDigest.digest());
    }
    /**
     * 传入16进制字符串加密
     * @param msg
     * @return
     */
    public static String encrypt(String msg) {
        byte[] bytes = ParseUtil.hexStringToBytes(msg);
        return encryptByteArray(bytes);
    }
}
