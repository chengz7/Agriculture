package com.farm.utils;
import java.math.BigInteger;
/**
 * @Author: Rain
 * @Description: crc16 modbus 检验工具类
 * @Date: Created on 2018/11/1 15:55
 */
public class CRCValidationUtil {
    /**
     * Modbus CRC校验低位在前，高位在后
     * @param crcData
     * @return
     */
    public static String CRC16ValidateForModbus(String crcData) {
        String res = CRC16Validate(crcData);
        return res.substring(2) + res.substring(0, 2);
    }
    /**
     * 对于传入的消息进行CRC校验，通过了返回true，否则返回false
     * 对于所有类型的消息都可以使用这个方法进行CRC校验
     * @param hexData
     * @return
     */
    public static Boolean CRC16Validation(String hexData) {
        //截取后四位
        String crcCode = hexData.substring(hexData.length() - 4);
        String crcContent = getCRCContent(hexData);
        if (crcCode.equals(CRC16Validate(crcContent))) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * 去掉“协议头”和包尾“CRC 校验码”后的内容校验,这个写的很好
     * 刚开始是这么写的 hexData.substring(4,74)
     * 改进了之后的写法对所有类型的消息都能够取出CRC校验内容，就是取出开头4位和
     * 末尾4位
     * @param hexData
     * @return
     */
    public static String getCRCContent(String hexData) {
        return hexData.substring(4, hexData.length() - 4);
    }
    /**
     * CRC加密
     * 传入16进制字符串，将字符串作为参数的方法暴露出来比较合适
     * CRC校验主要有两个用处：
     * 1.对于传入的消息进行CRC校验检验完整性
     * 2.对于发送的消息进行CRC校验之后生成CRC校验码再发送出去
     * crc校验码有四位，这个方法还用于外部对于发送的消息进行CRC加密
     * @param crcData
     * @return
     */
    public static String CRC16Validate(String crcData) {
        byte[] bytes = new BigInteger(crcData,16).toByteArray();
        String result = Integer.toHexString(CRC16Validate(bytes));
        if (result.length() == 3) {
            return "0" + result;
        } else {
            return result;
        }
    }
    /**
     * CRC16校验
     * @param arr_buff 待检校的byte数组
     * @return
     */
    private static int CRC16Validate(byte[] arr_buff) {
        int len = arr_buff.length;
        //预置 1 个 16 位的寄存器为十六进制FFFF, 称此寄存器为 CRC寄存器。
        int crc = 0xFFFF;
        int i, j;
        for (i = 0; i < len; i++) {
            //把第一个 8 位二进制数据 与 16 位的 CRC寄存器的低 8 位相异或, 把结果放于 CRC寄存器
            crc = ((crc & 0xFF00) | (crc & 0x00FF) ^ (arr_buff[i] & 0xFF));
            for (j = 0; j < 8; j++) {
                //把 CRC 寄存器的内容右移一位( 朝低位)用 0 填补最高位, 并检查右移后的移出位
                if ((crc & 0x0001) > 0) {
                    //如果移出位为 1, CRC寄存器与多项式A001进行异或
                    crc = crc >> 1;
                    crc = crc ^ 0xA001;
                } else
                    //如果移出位为 0,再次右移一位
                    crc = crc >> 1;
            }
        }
        return crc;
    }
}
