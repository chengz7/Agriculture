package com.farm.service;

import com.farm.entity.ErrorAndStatus;
import com.farm.entity.data.Packet;
import com.farm.entity.data.WeatherPacket;

import java.util.List;

/**
 * @Author: Rain
 * @Description: 对于解析好的数据进行存储，websocket推送
 * @Date: Created on 2018/11/10 16:21
 */
public interface DataHandlingService {

    /**
     * 将解析好的数据存储到数据库以及推送到WebSocket
     * @param packets
     */
    void storeAndPushData(List<Packet> packets);

    void storeAndPushWeatherData(WeatherPacket packet);

    void storeAndPushErrorStatusData(ErrorAndStatus status);


}
