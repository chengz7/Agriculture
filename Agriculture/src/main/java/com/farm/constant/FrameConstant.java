package com.farm.constant;

/**
 * @Author: Rain
 * @Description: 经常使用的modbus数据帧
 * @Date: Created on 2019-04-26 17:20
 */
public class FrameConstant {

    /**
     * LED的数据帧构成：帧头+内码+GB2312编码的数据+帧尾
     * 所有数据帧的帧头帧尾相同，不同的内码区对应的不同的内码
     * 0，2内码区显示相同数据：标语
     * 1，3内码区显示相同数据：LoRa网关上传传感器数据
     */
    public static final String LED_FRAME_HEADER = "55AA0000010100D9000000000000000000000000";

    public static final String LED_INTERNAL_CODE0 = "2564697370303A32";
    public static final String LED_INTERNAL_CODE1 = "2564697370313A32";
    public static final String LED_INTERNAL_CODE2 = "2564697370323A32";
    public static final String LED_INTERNAL_CODE3 = "2564697370333A32";

    public static final String LED_FRAME_TAIL = "00000D0A";

    public static final String READ_ERROR_STATUS = "01030014000B4409";

    public static final String READ_WEATHER_DATA = "010307D1000C1482";

    /**
     * Lora数据指令帧 7条
     */

    //四合一传感器对应的写指令
    public static final String frame1b64 = "0110083400050A";

    //二合一传感器对应写指令
    public static final String frame0003 = "01100839000306";

    public static final String frame0004 = "0110083C000306";

    public static final String frame0005 = "0110083F000306";

    //无线温湿度
    public static final String frame0001 = "01100842000204";

    //无线水温
    public static final String frame0002 = "01060844";

    //查询故障读指令
    public static final String CHECK_ERROR_FRAME = "01030014000B4409";

    //气象站传感器读指令帧
    public static final String CLIMATE_SENSOR_FRAME = "010307D1000C1482";

}
