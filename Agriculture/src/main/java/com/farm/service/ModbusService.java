package com.farm.service;
import com.farm.entity.data.Packet;
import com.farm.entity.data.WeatherPacket;
import java.util.List;
/**
 * @Author: Rain
 * @Description: 所有与Modbus协议数据有关的，无论是解析还是打包发送，都通过这个service
 * @Date: Created on 2019-04-28 20:28
 */
@SuppressWarnings("noinspection SpellCheckingInspection")
public interface ModbusService {
    /**
     * 将解析好的数据推送给PLC
     *
     * @param packets 解析好的数据包。
     */
    void sendLoraDataToPLC(List<Packet> packets);
/**
     * 把LORA数据推送给LED点阵屏
     *
     * @param packets
     *//*
    void sendLoraDataToLedDisplay(List<Packet> packets);
    */
/**
     * 把气象站数据推送给LED点阵屏
     *
     * @param packet
     *//*
    void sendWeatherDataToLedDisplay(WeatherPacket packet);
*/
}
