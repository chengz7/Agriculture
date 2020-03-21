package com.farm.utils;
import com.farm.entity.ErrorAndStatus;
import com.farm.entity.data.*;
import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * @Author: Rain
 * @Description:
 * @Date: Created on 2018/11/10 14:20
 */
@Slf4j
public class ParseUpStreamInfoUtil {
    public static ErrorAndStatus parseErrorAndFeedbackStatusData(String hexData) {
        String binaryStr = ParseUtil.strToBinStr(hexData.substring(6,50));
        return generateErrorData(binaryStr);
    }
    /**
     * 010316 0001 0000 0008 0000 0000 0000 0000 0000 0000 0000 0000 3770
     * 0000000000000001
     * 0000000000000000
     * 0000000000001000
     * 0000000000000000
     * 0000000000000000
     * 0000000000000000
     * 0000000000000000
     * 0000000000000000
     * 0000000000000000
     * 0000000000000000
     * 0000000000000000
     * @param str
     * @return
     */
    private static ErrorAndStatus generateErrorData(String str) {
        ErrorAndStatus status = new ErrorAndStatus();
        status.setWaiZheYang1_MotorFault(bitCheck(str, 1, 0));
        status.setWaiZheYang2_MotorFault(bitCheck(str, 1, 1));
        status.setNeiZheYang1_MotorFault(bitCheck(str, 1, 2));
        status.setNeiZheYang2_MotorFault(bitCheck(str, 1, 3));
        status.setFengJi1_SwitchMotorFault(bitCheck(str, 1, 4));
        status.setFengJi2_SwitchMotorFault(bitCheck(str, 1, 5));
        status.setGuanGaiShuiBeng_SwitchMotorFault(bitCheck(str, 1, 6));
        status.setShuiPeiShuiBeng_SwitchMotorFault(bitCheck(str, 1, 7));
        status.setShiFeiBeng_SwitchMotorFault(bitCheck(str, 1, 8));
        status.setZengYangJi_SwitchMotorFault(bitCheck(str, 1, 9));
        status.setReFengJi_SwitchMotorFault(bitCheck(str, 1, 10));
        status.setZhaoMing1_SwitchMotorFault(bitCheck(str, 1, 11));
        status.setZhaoMing2_SwitchMotorFault(bitCheck(str, 1, 12));
        status.setLED_SwitchMotorFault(bitCheck(str, 1, 13));
        status.setDingTongFeng_MotorFault(bitCheck(str, 1, 14));
        status.setWaiZheYang1_Forward_Feedback_Fault_Output(bitCheck(str, 1, 15));
        status.setWaiZheYang1_Reverse_Feedback_Fault_Output(bitCheck(str, 2, 0));
        status.setWaiZheYang2_Forward_Feedback_Fault_Output(bitCheck(str, 2, 1));
        status.setWaiZheYang2_Reverse_Feedback_Fault_Output(bitCheck(str, 2, 2));
        status.setNeiZheYang1_Forward_Feedback_Fault_Output(bitCheck(str, 2, 3));
        status.setNeiZheYang1_Reverse_Feedback_Fault_Output(bitCheck(str, 2, 4));
        status.setNeiZheYang2_Forward_Feedback_Fault_Output(bitCheck(str, 2, 5));
        status.setNeiZheYang2_Reverse_Feedback_Fault_Output(bitCheck(str, 2, 6));
        status.setFengJi1_Feedback_Fault_Output(bitCheck(str, 2, 7));
        status.setFengJi2_Feedback_Fault_Output(bitCheck(str, 2, 8));
        status.setGuanGaiShuiBeng_Feedback_Fault_Output(bitCheck(str, 2, 9));
        status.setShuiPeiShuiBeng_Feedback_Fault_Output(bitCheck(str, 2, 10));
        status.setShiFeiBeng_Feedback_Fault_Output(bitCheck(str, 2, 11));
        status.setZengYangJi_Feedback_Fault_Output(bitCheck(str, 2, 12));
        status.setReFengJi_Feedback_Fault_Output(bitCheck(str, 2, 13));
        status.setZhaoMing1_Feedback_Fault_Output(bitCheck(str, 2, 14));
        status.setZhaoMing2_Feedback_Fault_Output(bitCheck(str, 2, 15));
        status.setLED_Feedback_Fault_Output(bitCheck(str, 3, 0));
        status.setDingTongFeng_Forward_Feedback_Fault_Output(bitCheck(str, 3, 1));
        status.setDingTongFeng_Reverse_Feedback_Fault_Output(bitCheck(str, 3, 2));
        status.setFengMingQi(bitCheck(str, 3, 3));
        status.setRemote_Local_Control(bitCheck(str, 3, 4));
        status.setShuiLian_SwitchMotorFault(bitCheck(str,3,5));
        status.setShuiLian_Feedback_Fault_Output(bitCheck(str,3,6));
        status.setEmergency_Stop_State(bitCheck(str,3,7));
        status.setFengJi3_SwitchMotorFault(bitCheck(str,3,8));
        status.setFengJi3_Feedback_Fault_Output(bitCheck(str,3,9));
        status.setWaiZheYang1_Forward_FeedBack(bitCheck(str, 6, 0));
        status.setWaiZheYang1_Reverse_FeedBack(bitCheck(str, 6, 1));
        status.setWaiZheYang2_Forward_FeedBack(bitCheck(str, 6, 2));
        status.setWaiZheYang2_Reverse_FeedBack(bitCheck(str, 6, 3));
        status.setNeiZheYang1_Forward_FeedBack(bitCheck(str, 6, 4));
        status.setNeiZheYang1_Reverse_FeedBack(bitCheck(str, 6, 5));
        status.setNeiZheYang2_Forward_FeedBack(bitCheck(str, 6, 6));
        status.setNeiZheYang2_Reverse_FeedBack(bitCheck(str, 6, 7));
        status.setFengJi1_FeedBack(bitCheck(str, 6, 8));
        status.setFengJi2_FeedBack(bitCheck(str, 6, 9));
        status.setGuanGaiShuiBeng_FeedBack(bitCheck(str, 6, 10));
        status.setShuiPeiShuiBeng_FeedBack(bitCheck(str, 6, 11));
        status.setShiFeiBeng_FeedBack(bitCheck(str, 6, 12));
        status.setZengYangJi_FeedBack(bitCheck(str, 6, 13));
        status.setReFengJi_FeedBack(bitCheck(str, 6, 14));
        status.setZhaoMing1_FeedBack(bitCheck(str, 6, 15));
        status.setZhaoMing2_FeedBack(bitCheck(str, 7, 0));
        status.setLED_FeedBack(bitCheck(str, 7, 1));
        status.setDingTongFeng_Forward_FeedBack(bitCheck(str, 7, 2));
        status.setDingTongFeng_Reverse_FeedBack(bitCheck(str, 7, 3));
        status.setShuiLianBuShui_ElectromagneticValveOutput(bitCheck(str, 7, 4));
        status.setShuiChiBuShui_ElectromagneticValveOutput(bitCheck(str, 7, 5));
        status.setMiaoChuangGuanGai1_ElectromagneticValveOutput(bitCheck(str, 7, 6));
        status.setMiaoChuangGuanGai2_ElectromagneticValveOutput(bitCheck(str, 7, 7));
        status.setMiaoChuangGuanGai3_ElectromagneticValveOutput(bitCheck(str, 7, 8));
        status.setMiaoChuangGuanGai4_ElectromagneticValveOutput(bitCheck(str, 7, 9));
        status.setMiaoChuangGuanGai5_ElectromagneticValveOutput(bitCheck(str, 7, 10));
        status.setMiaoChuangGuanGai6_ElectromagneticValveOutput(bitCheck(str, 7, 11));
        status.setMiaoChuangGuanGai7_ElectromagneticValveOutput(bitCheck(str, 7, 12));
        status.setMiaoChuangGuanGai8_ElectromagneticValveOutput(bitCheck(str, 7, 13));
        status.setMiaoChuangGuanGai9_ElectromagneticValveOutput(bitCheck(str, 7, 14));
        status.setMiaoChuangGuanGai10_ElectromagneticValveOutput(bitCheck(str, 7, 15));
        status.setMiaoChuangGuanGai11_ElectromagneticValveOutput(bitCheck(str, 8, 0));
        status.setMiaoChuangGuanGai12_ElectromagneticValveOutput(bitCheck(str, 8, 1));
        status.setMiaoChuangGuanGai13_ElectromagneticValveOutput(bitCheck(str, 8, 2));
        status.setMiaoChuangGuanGai14_ElectromagneticValveOutput(bitCheck(str, 8, 3));
        status.setMiaoChuangGuanGai15_ElectromagneticValveOutput(bitCheck(str, 8, 4));
        status.setMiaoChuangGuanGai16_ElectromagneticValveOutput(bitCheck(str, 8, 5));
        status.setMiaoChuangGuanGai17_ElectromagneticValveOutput(bitCheck(str, 8, 6));
        status.setMiaoChuangGuanGai18_ElectromagneticValveOutput(bitCheck(str, 8, 7));
        status.setMiaoChuangGuanGai19_ElectromagneticValveOutput(bitCheck(str, 8, 8));
        status.setMiaoChuangGuanGai20_ElectromagneticValveOutput(bitCheck(str, 8, 9));
        status.setMiaoChuangGuanGai21_ElectromagneticValveOutput(bitCheck(str, 8, 10));
        status.setMiaoChuangGuanGai22_ElectromagneticValveOutput(bitCheck(str, 8, 11));
        status.setMiaoChuangGuanGai23_ElectromagneticValveOutput(bitCheck(str, 8, 12));
        status.setMiaoChuangGuanGai24_ElectromagneticValveOutput(bitCheck(str, 8, 13));
        status.setMiaoChuangGuanGai25_ElectromagneticValveOutput(bitCheck(str, 8, 14));
        status.setMiaoChuangGuanGai26_ElectromagneticValveOutput(bitCheck(str, 8, 15));
        status.setMiaoChuangGuanGai27_ElectromagneticValveOutput(bitCheck(str, 9, 0));
        status.setMiaoChuangGuanGai28_ElectromagneticValveOutput(bitCheck(str, 9, 1));
        status.setMiaoChuangGuanGai29_ElectromagneticValveOutput(bitCheck(str, 9, 2));
        status.setMiaoChuangGuanGai30_ElectromagneticValveOutput(bitCheck(str, 9, 3));
        status.setMiaoChuangGuanGai31_ElectromagneticValveOutput(bitCheck(str, 9, 4));
        status.setMiaoChuangGuanGai32_ElectromagneticValveOutput(bitCheck(str, 9, 5));
        status.setMiaoChuangGuanGai33_ElectromagneticValveOutput(bitCheck(str, 9, 6));
        status.setMiaoChuangGuanGai34_ElectromagneticValveOutput(bitCheck(str, 9, 7));
        status.setMiaoChuangGuanGai35_ElectromagneticValveOutput(bitCheck(str, 9, 8));
        status.setMiaoChuangGuanGai36_ElectromagneticValveOutput(bitCheck(str, 9, 9));
        status.setMiaoChuangGuanGai37_ElectromagneticValveOutput(bitCheck(str, 9, 10));
        status.setMiaoChuangGuanGai38_ElectromagneticValveOutput(bitCheck(str, 9, 11));
        status.setMiaoChuangGuanGai39_ElectromagneticValveOutput(bitCheck(str, 9, 12));
        status.setMiaoChuangGuanGai40_ElectromagneticValveOutput(bitCheck(str, 9, 13));
        status.setMiaoChuangGuanGai41_ElectromagneticValveOutput(bitCheck(str, 9, 14));
        status.setMiaoChuangGuanGai42_ElectromagneticValveOutput(bitCheck(str, 9, 15));
        status.setMiaoChuangGuanGai43_ElectromagneticValveOutput(bitCheck(str, 10, 0));
        status.setMiaoChuangGuanGai44_ElectromagneticValveOutput(bitCheck(str, 10, 1));
        status.setMiaoChuangGuanGai45_ElectromagneticValveOutput(bitCheck(str, 10, 2));
        status.setMiaoChuangGuanGai46_ElectromagneticValveOutput(bitCheck(str, 10, 3));
        status.setMiaoChuangGuanGai47_ElectromagneticValveOutput(bitCheck(str, 10, 4));
        status.setMiaoChuangGuanGai48_ElectromagneticValveOutput(bitCheck(str, 10, 5));
        status.setMiaoChuangGuanGai49_ElectromagneticValveOutput(bitCheck(str, 10, 6));
        status.setMiaoChuangGuanGai50_ElectromagneticValveOutput(bitCheck(str, 10, 7));
        status.setMiaoChuangGuanGai51_ElectromagneticValveOutput(bitCheck(str, 10, 8));
        status.setMiaoChuangGuanGai52_ElectromagneticValveOutput(bitCheck(str, 10, 9));
        status.setMiaoChuangGuanGai53_ElectromagneticValveOutput(bitCheck(str, 10, 10));
        status.setMiaoChuangGuanGai54_ElectromagneticValveOutput(bitCheck(str, 10, 11));
        status.setMiaoChuangGuanGai55_ElectromagneticValveOutput(bitCheck(str, 10, 12));
        status.setMiaoChuangGuanGai56_ElectromagneticValveOutput(bitCheck(str, 10, 13));
        status.setMiaoChuangGuanGai57_ElectromagneticValveOutput(bitCheck(str, 10, 14));
        status.setMiaoChuangGuanGai58_ElectromagneticValveOutput(bitCheck(str, 10, 15));
        status.setMiaoChuangGuanGai59_ElectromagneticValveOutput(bitCheck(str, 11, 0));
        status.setMiaoChuangGuanGai60_ElectromagneticValveOutput(bitCheck(str,11,1));
        status.setShuiLian_FeedBack(bitCheck(str,11,2));
        status.setFengJi3_FeedBack(bitCheck(str,11,3));
        return status;
    }
    /**
     * 把二进制字符串相应word的位翻译为Boolean值
     *
     * @param binStr    二进制字符串
     * @param wordIndex 第几个word，从1开始
     * @param bitIndex  word中的第几位，从0开始
     * @return
     */
    private static boolean bitCheck(String binStr, int wordIndex, int bitIndex) {
        int index = wordIndex*16-bitIndex-1;
        char c = binStr.charAt(index);
        return c == '1' ? true : false;
    }
    /**
     * 解析DTU上传的气象站数据包
     * 01 03 18 00FA 00FA 0000 0000 0000 0000 0000 00000064 0000 003F 0001 0334
     * 湿度 温度
     *
     * @param hexData
     * @return
     */
    public static WeatherPacket parseWeatherPacket(String hexData) {
        WeatherPacket packet = new WeatherPacket();
        packet.setDeviceId("000004");
        packet.setWeatherHumidity(ParseUtil.hexStringToInt(hexData.substring(6, 10)) / 10);
        packet.setWeatherTemp(ParseUtil.hexStringToInt(hexData.substring(10, 14)) / 10);
        packet.setWeatherIntensity(ParseUtil.hexStringToInt(hexData.substring(34, 42))/1000);
        packet.setECValue(ParseUtil.hexStringToInt(hexData.substring(42, 46)) / 10);
        packet.setWindSpeed(ParseUtil.hexStringToInt(hexData.substring(46, 50)) / 10);
        packet.setRainOrSnow(ParseUtil.hexStringToInt(hexData.substring(50, 54)));
        packet.setCommitTime(new Date());
        return packet;
    }
    /**
     * 网关会发送无效信息，比如这种Lora节点id为0000，信息包为0000000000，排除这些无效信息，
     * 收到这些无效信息直接返回，不需要插入数据
     * fffe 15 0a 07 0000 120b0b113a0b 00 83 92 01 0000000000 50eb
     * fffe 24 0a 07 1b66 000000001935 00 7f 99 04 0054563618 0155000000 0200000000 0302cd0000 0e33
     * fffe 24 0a 07 1b66 120b0e0e1115 00 7f 97 04 0054134009 0154000000 0200010000 0303770000 096b
     * fffe 15 0a 07 0001 000000010217 00 85 84 01 0053193b2c 3d58
     * fffe 15 0a 07 0002 000000003b19 00 85 90 01 1353280000 86c7
     * fffe 15 0a 07 0002 000000000b27 00 87 9c 01 13530a0000 5fb4
     * fffe 1a 0a 07 0003 00000000031b 00 85 8c 02 0052594232 0151000000 dcb2
     * fffe 1a 0a 07 0004 000000003b19 00 85 87 02 0053054354 0152000000 d8a1
     * fffe 1a 0a 07 0005 000000010739 00 85 8b 02 00525f4102 0152000000 a566
     * fffe 24 0a 07 1b64 000000010b27 00 85 79 04 00525c411d 0152000000 02000a0000 0303180000 a406
     *
     * @param hexData
     * @return 无效信息返回false，有效信息返回true。
     */
    public static boolean isValidInfo(String hexData) {
        String loraNodeId = getLoraNodeId(hexData);
        String content = hexData.substring(34, 44);
        if (loraNodeId.equals("0000") && content.equals("0000000000"))
            return false;
        else
            return true;
    }
    /**
     * 解析网关数据包方法
     *
     * @param hexData 网关上传数据
     * @return
     */
    public static List<Packet> parseGatewayPackets(String hexData) {
        //上传的数据包数量
        int dataPacketNum = ParseUtil.hexStringToInt(hexData.substring(32, 34));
        List<Packet> packets = new ArrayList<>();
        List<String> hexStringDataPackets = new ArrayList<>();
        String loraNodeId = getLoraNodeId(hexData);
        //把数据包按照数量截取 数据包：传感器类型+数据1+数据2
        for (int i = 0; i < dataPacketNum; i++) {
            //数据包处于17-22
            hexStringDataPackets.add(hexData.substring(34 + 10 * i, 44 + 10 * i));
        }
        for (String hexString : hexStringDataPackets) {
            //数据类型/控制器类型
            String dataType = hexString.substring(0, 2);
            //数据包内容，2个word, 去除数据类型，4个byte
            String submitData = hexString.substring(2);
            switch (dataType) {
                case "00":
                    AirPacket airPacket = new AirPacket();
                    airPacket.setLoraNodeId(loraNodeId);
                    airPacket.setDeviceId(loraNodeId + dataType);
                    airPacket.setDataType(0);
                    airPacket.setCommitTime(new Date());
                    handleAirTemperatureData(submitData, airPacket);
                    if (loraNodeId.equals("03b6")) {
                        WaterPacket waterPacket = new WaterPacket();
                        waterPacket.setLoraNodeId(loraNodeId);
                        waterPacket.setDeviceId(loraNodeId + dataType);
                        waterPacket.setDataType(19);
                        waterPacket.setCommitTime(new Date());
                        waterPacket.setWaterTemp(airPacket.getAirTemp());
                        packets.add(waterPacket);
                    } else {
                        packets.add(airPacket);
                    }
                    break;
                case "01":
                    SoilPacket soilPacket = new SoilPacket();
                    soilPacket.setLoraNodeId(loraNodeId);
                    soilPacket.setDeviceId(loraNodeId + dataType);
                    soilPacket.setDataType(1);
                    soilPacket.setCommitTime(new Date());
                    handleSoilHumidityData(submitData, soilPacket);
                    packets.add(soilPacket);
                    break;
                case "02":
                    SunlightPacket sunlightPacket = new SunlightPacket();
                    sunlightPacket.setLoraNodeId(loraNodeId);
                    sunlightPacket.setDeviceId(loraNodeId + dataType);
                    sunlightPacket.setDataType(2);
                    sunlightPacket.setCommitTime(new Date());
                    handleSunshineIntensityData(submitData, sunlightPacket);
                    packets.add(sunlightPacket);
                    break;
                case "03":
                    CO2Packet co2Packet = new CO2Packet();
                    co2Packet.setLoraNodeId(loraNodeId);
                    co2Packet.setDeviceId(loraNodeId + dataType);
                    co2Packet.setDataType(3);
                    co2Packet.setCommitTime(new Date());
                    handleCarbonDioxideConcentrationData(submitData, co2Packet);
                    packets.add(co2Packet);
                    break;
                case "13":
                    WaterPacket waterPacket = new WaterPacket();
                    waterPacket.setLoraNodeId(loraNodeId);
                    waterPacket.setDeviceId(loraNodeId + dataType);
                    waterPacket.setDataType(19);
                    waterPacket.setCommitTime(new Date());
                    handleWaterTempData(submitData, waterPacket);
                    packets.add(waterPacket);
                    break;
                default:
                    log.warn("未知类型传感器提交的数据");
                    break;
            }
        }
        return packets;
    }
    /**
     * 19、水温数据，高位字节是整数部分，低位字节是小数部分，上传的温度值为实际温度
     *
     * @param data   53280000
     * @param packet
     */
    private static void handleWaterTempData(String data, WaterPacket packet) {
        Float temperature = getFloatFromData(data.substring(0, 4)) - 64;
        packet.setWaterTemp(round(temperature));
    }
    /**
     * 3、二氧化碳，Word，数据整数部分，单位PPM
     *
     * @param data
     * @param packet
     */
    private static void handleCarbonDioxideConcentrationData(String data, CO2Packet packet) {
        Float concentration = Float.valueOf(ParseUtil.hexStringToInt(data.substring(0, 4)));
        packet.setConcentration(concentration);
    }
    /**
     * 2、是日照，高位字节是整数部分，低位字节是小数部分 单位是 klux
     *
     * @param data
     * @param packet
     */
    private static void handleSunshineIntensityData(String data, SunlightPacket packet) {
        packet.setIntensity(getFloatFromData(data));
    }
    /**
     * 1、是土壤，高位字节是温度，范围是-64到191，低位字节是水分百分比
     *
     * @param data
     * @param packet
     */
    private static void handleSoilHumidityData(String data, SoilPacket packet) {
        //土壤温度
        Float soilTemperature = Float.valueOf(ParseUtil.hexStringToInt(data.substring(0, 2)) - 64);
        packet.setSoilTemp(soilTemperature);
        //土壤水分百分比
        Float waterContent = Float.valueOf(ParseUtil.hexStringToInt(data.substring(2, 4)));
        packet.setSoilHumidity(waterContent);
    }
    /**
     * 0、第一个数据为温度数据，高字节是整数,低字节是小数。上传的温度值为实际温度值+64℃；
     *
     * @param data   2个word, 去除数据类型
     * @param packet
     */
    private static void handleAirTemperatureData(String data, AirPacket packet) {
        Float temperature = getFloatFromData(data.substring(0, 4)) - 64;
        //第一个word空气温度
        packet.setAirTemp(round(temperature));
        //第二个word空气湿度
        packet.setAirHumidity(getFloatFromData(data.substring(4)));
    }
    /**
     * 对于所有高字节是整数，低字节是小数的数据抽取的工具方法
     *
     * @param data word
     * @return
     */
    private static Float getFloatFromData(String data) {
        StringBuilder builder = new StringBuilder();
        String temp;
        //日照强度整数部分
        temp = Integer.toString(ParseUtil.hexStringToInt(data.substring(0, 2)));
        builder.append(temp);
        //加个小数点
        builder.append(".");
        //日照强度小数部分
        temp = Integer.toString(ParseUtil.hexStringToInt(data.substring(2, 4)));
        builder.append(temp);
        return Float.valueOf(builder.toString());
    }
    /**
     * 把小数位数超过两位的转换为只保留小数点后两位
     *
     * @param data
     * @return
     */
    private static Float round(Float data) {
        float a = data.floatValue();
        float b = (float) (Math.round(a * 100)) / 100;
        return Float.valueOf(b);
    }
    /**
     * @param hexData 网关提交的16进制字符串
     * @return 07类型提交数据的Lora节点id
     */
    private static String getLoraNodeId(String hexData) {
        return hexData.substring(10, 14);
    }
}
