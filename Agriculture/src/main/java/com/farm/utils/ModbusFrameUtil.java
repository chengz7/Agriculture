package com.farm.utils;

import com.farm.constant.StaticVariable;
import com.farm.constant.FrameConstant;
import com.farm.entity.data.*;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Rain
 * @Description:
 * @Date: Created on 2019-04-28 21:45
 */
@Slf4j
@SuppressWarnings("noinspection SpellCheckingInspection")
public class ModbusFrameUtil {

    /**
     * 室外数据
     * @param packet
     * @return
     */
    public static String extractWeatherDataForLED(WeatherPacket packet) {
        StringBuilder ledMsg = new StringBuilder();
        ledMsg = ledMsg.append("   ***室外*** 温度：").append(packet.getWeatherTemp().toString())
                .append("℃   ").append("湿度：").append(packet.getWeatherHumidity())
                .append("%   ").append("光照：").append(packet.getWeatherIntensity())
                .append("klux   ").append("EC：").append(packet.getECValue())
                .append("   风速：").append(packet.getWindSpeed()).append("m/s   ")
                .append("降水：").append(packet.getRainOrSnow());
        return ledMsg.toString();
    }

    /**
     * 把LoRa信息封装成传给LED的数据/字符串
     * @param packets
     * @return
     */
    public static String extractFrameForLED(List<Packet> packets) {
        Map<String, String> map = getLEDMsgMapFromPackets(packets);
        String loraNodeId = map.get("loraNodeId");
        StringBuilder ledMsg = new StringBuilder();
        switch (loraNodeId) {
            case "0001":
                ledMsg = ledMsg.append("   ***室内*** 温度：").append(map.get("airTemp")).append("℃   ")
                        .append("湿度：").append(map.get("airHumi")).append("%");
                break;
            case "0002":
                ledMsg = ledMsg.append("   ***室内*** 水温：").append(map.get("waterTemp")).append("℃");
                break;
            case "0003":
            case "0004":
            case "0005":
                ledMsg = ledMsg.append("   ***室内*** 温度：").append(map.get("airTemp")).append("℃   ")
                        .append("湿度：").append(map.get("airHumi")).append("%    ")
                        .append("土壤湿度：").append(map.get("soilHumi")).append("%");
                break;
            case "1b64":
                ledMsg = ledMsg.append("   ***室内*** 温度：").append(map.get("airTemp")).append("℃   ")
                        .append("湿度：").append(map.get("airHumi")).append("%    ")
                        .append("土壤湿度：").append(map.get("soilHumi")).append("%")
                        .append("二氧化碳浓度：").append(map.get("concn")).append("PPM")
                        .append("光照：").append(map.get("intensity")).append("klux");
                break;
        }
        return ledMsg.toString();
    }

    /**
     * Led数据
     * @param map
     * @return
     */
    public static String extractFrameForLED(Map<String, String> map) {
        StringBuilder msg = new StringBuilder();
        msg = msg.append("室外:温度").append(map.getOrDefault("weatherTemp","18")).append("℃")
                .append("湿度").append(map.getOrDefault("weatherHumi","60")).append("%")
                .append("风速:").append(map.getOrDefault("windSpeed","0")).append("m/s")
                .append("光照:").append(map.getOrDefault("intensity","72")).append("klux")
                .append(map.getOrDefault("rain","无降水"))
                .append(" 室内:温度").append(map.getOrDefault("airTemp","18")).append("℃")
                .append("湿度:").append(map.getOrDefault("airHumi","30")).append("%")
                .append("土壤湿度:").append(map.getOrDefault("soilHumi","2")).append("%")
                .append("水温:").append(map.getOrDefault("waterTemp","18")).append("℃")
                .append("光照:").append(map.getOrDefault("intensity","72")).append("klux")
                .append("二氧化碳:").append(map.getOrDefault("concn","500")).append("PPM");
        return msg.toString();

    }

    /**
     * 室外
     * @param packet
     * @return
     */
    public static Map<String, String> updateLEDDataMapFromPacket(WeatherPacket packet) {
        Map<String,String> map = StaticVariable.LedDataMap;
        map.put("weatherTemp", packet.getWeatherTemp().toString());
        map.put("weatherHumi", packet.getWeatherHumidity().toString());
        map.put("intensity", packet.getWeatherIntensity().toString());
        map.put("windSpeed", packet.getWindSpeed().toString());
        if (packet.getRainOrSnow()==1) {
            map.put("rain", "有降水");
        } else {
            map.put("rain", "无降水");
        }
        return map;
    }

    /**
     * 室内
     * @param packets
     * @return
     */
    public static Map<String, String> updateLEDDataMapFromPackets(List<Packet> packets) {
        Map<String,String> map = StaticVariable.LedDataMap;
        for (Packet packet : packets) {
            if (packet instanceof AirPacket && ((AirPacket) packet).getLoraNodeId().equals("0003")) {
                map.put("airTemp", ((AirPacket) packet).getAirTemp().toString());
                map.put("airHumi", ((AirPacket) packet).getAirHumidity().toString());
            } else if (packet instanceof SoilPacket && ((SoilPacket) packet).getLoraNodeId().equals("0003")) {
                map.put("soilHumi", ((SoilPacket) packet).getSoilHumidity().toString());
            } else if (packet instanceof CO2Packet && ((CO2Packet) packet).getLoraNodeId().equals("1b64")) {
                map.put("concn", ((CO2Packet) packet).getConcentration().toString());
            } else if (packet instanceof SunlightPacket && ((SunlightPacket) packet).getLoraNodeId().equals("1b64")) {
                map.put("intensity", ((SunlightPacket) packet).getIntensity().toString());
            } else if (packet instanceof WaterPacket && ((WaterPacket) packet).getLoraNodeId().equals("0002")) {
                map.put("waterTemp", ((WaterPacket) packet).getWaterTemp().toString());
            }
        }
        return map;
    }

    /**
     *
     * @param packets 是封装好的Lora信息帧，从这里把数据取出来发给PLC。
     * @return
     */
    public static String extractFrameFromLora(List<Packet> packets) {
        Map<String, String> map = getMsgMapFromPackets(packets);

        String loraNodeId = map.get("loraNodeId");
        StringBuilder plcMsg = new StringBuilder();
        switch (loraNodeId) {
            /**
             * 03b7:四合一节点，按照 空气温度->空气湿度->土壤湿度->co2浓度->光照
             * fffe150a070001000000002e2100816401005f5c5016158c
             */
            case "03b7":
                plcMsg = plcMsg.append(FrameConstant.frame1b64).append(map.get("airTemp"))
                                .append(map.get("airHumi")).append(map.get("soilHumi"))
                                .append(map.get("concn")).append(map.get("intensity"));
                break;
            /**
             * 0001: 无线温湿度 按照 空气温度->空气湿度
             */
            case "0001":
                plcMsg = plcMsg.append(FrameConstant.frame0001).append(map.get("airTemp"))
                                .append(map.get("airHumi"));
                break;
            /**
             * 03b6:无线水温 水温
             */
            case "03b6":
                plcMsg = plcMsg.append(FrameConstant.frame0002).append(map.get("waterTemp"));
                break;
            /**
             * 0003/0004/0005 二合一传感器 按照空气温度->空气湿度->土壤湿度
             */
            case "0003":
                //map.getOrDefault("airTemp", "0040");
                plcMsg = plcMsg.append(FrameConstant.frame0003).append(map.get("airTemp"))
                        .append(map.get("airHumi")).append(map.get("soilHumi"));
                break;
            case "0004":
                plcMsg = plcMsg.append(FrameConstant.frame0004).append(map.get("airTemp"))
                        .append(map.get("airHumi")).append(map.get("soilHumi"));
                break;
            case "0005":
                plcMsg = plcMsg.append(FrameConstant.frame0005).append(map.get("airTemp"))
                        .append(map.get("airHumi")).append(map.get("soilHumi"));
                break;
            default:
                log.warn("unexpected msg from plc message parsing");
                break;
        }
        //加上CRC校验
        String crc = CRCValidationUtil.CRC16ValidateForModbus(plcMsg.toString());
        plcMsg = plcMsg.append(crc);
        return plcMsg.toString();
    }

    /**
     *
     * @param packets 解析好的带有传感器数据的List,数据给PLC
     * @return
     */
    private static Map<String, String> getMsgMapFromPackets(List<Packet> packets) {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < packets.size(); i++) {
            Packet packet = packets.get(i);
            if (packet instanceof AirPacket){
                map.put("loraNodeId",((AirPacket) packet).getLoraNodeId());
                map.put("airTemp", floatToIntString(((AirPacket) packet).getAirTemp()));
                map.put("airHumi", floatToIntString(((AirPacket) packet).getAirHumidity()));
            } else if (packet instanceof SoilPacket) {
                map.put("loraNodeId",((SoilPacket) packet).getLoraNodeId());
                map.put("soilHumi", floatToIntString(((SoilPacket) packet).getSoilHumidity()));
            } else if (packet instanceof SunlightPacket) {
                map.put("loraNodeId", ((SunlightPacket) packet).getLoraNodeId());
                map.put("intensity", floatToIntString(((SunlightPacket) packet).getIntensity() * 1000));
            } else if (packet instanceof CO2Packet) {
                map.put("loraNodeId", ((CO2Packet) packet).getLoraNodeId());
                map.put("concn", floatToIntString(((CO2Packet) packet).getConcentration()));
            } else if (packet instanceof WaterPacket) {
                map.put("loraNodeId", ((WaterPacket) packet).getLoraNodeId());
                map.put("waterTemp", floatToIntString(((WaterPacket) packet).getWaterTemp()));
            }
        }
        return map;
    }

    private static Map<String, String> getLEDMsgMapFromPackets(List<Packet> packets) {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < packets.size(); i++) {
            Packet packet = packets.get(i);
            if (packet instanceof AirPacket){
                map.put("loraNodeId",((AirPacket) packet).getLoraNodeId());
                map.put("airTemp", ((AirPacket) packet).getAirTemp().toString());
                map.put("airHumi", ((AirPacket) packet).getAirHumidity().toString());
            } else if (packet instanceof SoilPacket) {
                map.put("loraNodeId",((SoilPacket) packet).getLoraNodeId());
                map.put("soilHumi", ((SoilPacket) packet).getSoilHumidity().toString());
            } else if (packet instanceof SunlightPacket) {
                map.put("loraNodeId", ((SunlightPacket) packet).getLoraNodeId());
                map.put("intensity", ((SunlightPacket) packet).getIntensity().toString());
            } else if (packet instanceof CO2Packet) {
                map.put("loraNodeId", ((CO2Packet) packet).getLoraNodeId());
                map.put("concn", ((CO2Packet) packet).getConcentration().toString());
            } else if (packet instanceof WaterPacket) {
                map.put("loraNodeId", ((WaterPacket) packet).getLoraNodeId());
                map.put("waterTemp", ((WaterPacket) packet).getWaterTemp().toString());
            }
        }
        return map;
    }



    /**
     * 返回代表浮点数整数的16进制字符串,而且确保这个字符串长度4位,这个方法把数据给底层PLC
     * @param f
     * @return
     */
    public static String floatToIntString(Float f) {
        int i = f.intValue()+64;
        String res = Integer.toHexString(i);
        if (res.length() == 2) {
            res = "00" + res;
        } else if (res.length() == 3) {
            res = "0" + res;
        } else if (res.length() == 1) {
            res = "000" + res;
        } else {
            res = "0000";
        }
        return res;
    }


}
