package com.farm.utils;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import lombok.extern.slf4j.Slf4j;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * @Author: Rain
 * @Description: 数据解析工具类
 *  substring(8, 10),左开右闭，包括从零开始的第八位，到第九位，不包括第十位
 * @Date: Created on 2018/11/1 15:55
 */
@Slf4j
public class ParseUtil {
    /**
     * msg进行GB2312编码得到相应的16进制字符串
     * @param msg
     * @return
     */
    public static String encodeToGB2312(String msg){
        try {
            byte[] byteArray = msg.getBytes("GB2312");
            return byteArrayToHexString(byteArray);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * 把date类型数据转换为16进制字符串,如：
     * 18 09 13 15 54 43+0800  -> 每两位一一对应，+8000不用管
     * 12 09 0d 0f 36 2b
     * 用于给网关中心授时
     * @param date
     * @return
     */
    public static String parseDateToHexString(Date date) {
        String format = new SimpleDateFormat("yyMMddHHmmssZ").format(date);
        StringBuilder hexString = new StringBuilder();
        String temp;
        for (int i = 0; i < 6; i++) {
            temp = Integer.toHexString(Integer.parseInt(format.substring(2 * i, 2 * i + 2)));
            //长度不足2补零
            if (temp.length() != 2) {
                hexString.append("0" + temp);
            } else {
                hexString.append(temp);
            }
        }
        return hexString.toString();
    }
    /**
     *  11 07 1B 0F 20 01 (2017/07/27/15:32:01)
     * @param hexString
     */
    public static Date parseHexStringToDate(String hexString) {
        int yearNum = Integer.parseInt(hexString.substring(0, 2), 16)+2000;
        int monthNum = Integer.parseInt(hexString.substring(2, 4), 16);
        int dateNum = Integer.parseInt(hexString.substring(4, 6), 16);
        int hourNum = Integer.parseInt(hexString.substring(6,8),16);
        int minNum = Integer.parseInt(hexString.substring(8, 10), 16);
        int secNum = Integer.parseInt(hexString.substring(10, 12),16);
        Calendar cal = Calendar.getInstance();
        cal.set(yearNum,monthNum-1,dateNum,hourNum,minNum,secNum);
        return cal.getTime();
    }
    /**
     * 向网关/dtu发送消息方法，
     * @param channel
     * @param msg
     */
    public static void sendMsgThroughChannel(Channel channel, String msg) {
        ByteBuf returnMsg = Unpooled.buffer();
        returnMsg.writeBytes(ParseUtil.hexStringToBytes(msg));
        channel.writeAndFlush(returnMsg);
    }
    /**
     * 获取字符串第八位和第九位，代表了消息类型
     * Integer.toString方法可以把整数转换为String，配合这个方法可以很方便的把
     * 十六进制数转换为十进制整数或字符串
     * @param data
     * @return
     */
    public static String getDataType(String data) {
        return data.substring(8, 10);
    }
    //字节数组转换为hex16进制字符串
    public static String byteArrayToHexString(byte[] byteArray) {
        final StringBuilder hexString = new StringBuilder("");
        if (byteArray == null || byteArray.length <= 0)
            return null;
        for (int i = 0; i < byteArray.length; i++) {
            int v = byteArray[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                hexString.append(0);
            }
            hexString.append(hv);
        }
        return hexString.toString().toLowerCase();
    }
    /**
     * 把十六进制字符串转换为对应的十进制数
     * 比如传入十六进制字符串12，给出int型18
     * @param hexString
     * @return
     */
    public static int hexStringToInt(String hexString) {
        return Integer.parseInt(hexString,16);
    }
    /**
     * 16进制字符串转换为byte字节数组
     * @param str
     * @return
     */
    public static byte[] hexStringToBytes(String str) {
        if(str == null || str.trim().equals("")) {
            return new byte[0];
        }
        byte[] bytes = new byte[str.length() / 2];
        for(int i = 0; i < str.length() / 2; i++) {
            String subStr = str.substring(i * 2, i * 2 + 2);
            bytes[i] = (byte) Integer.parseInt(subStr, 16);
        }
        return bytes;
    }
    /**
     * 16进制字符串转换为二进制字符串
     * ffff -> 1111111111111111
     * @param str
     * @return
     */
    public static String strToBinStr(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            switch (c) {
                case '0':
                    result.append("0000");
                    break;
                case '1':
                    result.append("0001");
                    break;
                case '2':
                    result.append("0010");
                    break;
                case '3':
                    result.append("0011");
                    break;
                case '4':
                    result.append("0100");
                    break;
                case '5':
                    result.append("0101");
                    break;
                case '6':
                    result.append("0110");
                    break;
                case '7':
                    result.append("0111");
                    break;
                case '8':
                    result.append("1000");
                    break;
                case '9':
                    result.append("1001");
                    break;
                case 'a':
                case 'A':
                    result.append("1010");
                    break;
                case 'b':
                case 'B':
                    result.append("1011");
                    break;
                case 'c':
                case 'C':
                    result.append("1100");
                    break;
                case 'd':
                case 'D':
                    result.append("1101");
                    break;
                case 'e':
                case 'E':
                    result.append("1110");
                    break;
                case 'f':
                case 'F':
                    result.append("1111");
                    break;
                default:
                    result.append("1111");
                    break;
            }
        }
        return result.toString();
    }
}
