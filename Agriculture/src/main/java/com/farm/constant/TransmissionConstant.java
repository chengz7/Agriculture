package com.farm.constant;

import io.netty.channel.Channel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: Rain
 * @Description: netty解码器使用的常量
 * @Date: Created on 2019-04-25 15:50
 */
@SuppressWarnings("noinspection SpellCheckingInspection")
public class TransmissionConstant {

    //网关IP地址
    public static final String LORA_GATE_IP = "202.114.144.228";

    //DTU IP地址
    public static final String DTU_IP = "192.168.1.104";

    //Lora网关信息头
    public static final String LORA_MSG_HEADER = "fffe";

    //03读指令
    public static final String MODBUS_READ_CODE = "0103";

    //03功能码应答帧除了数据区之外的长度：01 03 长度位 CRC 总共5个byte
    public static final int READ_CODE_EXTRA = 5;

    //06写指令
    public static final String MODBUS_WRITE_CODE = "0106";

    //10读指令
    public static final String MODBUS_MULTI_WRITE_CODE = "0110";

    //3132303631323034
    public static final String DTU_REGISTER_CODE = "3132";

    //写指令应答帧长度8个byte
    public static final int WRITE_REPLY_FRAME_LENGTH = 8;

    private static Map<String, Channel> channelMap = new ConcurrentHashMap<>();

    public static Map<String, Channel> getMap() {
        return channelMap;
    }
}
