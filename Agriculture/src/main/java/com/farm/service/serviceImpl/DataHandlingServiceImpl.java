package com.farm.service.serviceImpl;

import com.farm.controller.websocket.WebSocket;
import com.farm.dao.PacketDao;
import com.farm.entity.ErrorAndStatus;
import com.farm.entity.data.*;
import com.farm.service.DataHandlingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Rain
 * @Description: 真正的数据处理service
 * @Date: Created on 2018/11/10 16:27
 */
@Service
@Slf4j
public class DataHandlingServiceImpl implements DataHandlingService {

    @Autowired
    private WebSocket webSocket;

    @Autowired
    private PacketDao packetDao;


    @Override
    public void storeAndPushData(List<Packet> packets) {
        Map<String, Object> map = new HashMap<>();
        map.put("list", packets);
        webSocket.pushPacketsToUsers(map);
        for (Packet packet : packets) {
            if (packet instanceof AirPacket)
                packetDao.insertAirPacket((AirPacket) packet);
            else if (packet instanceof SoilPacket)
                packetDao.insertSoilPacket((SoilPacket) packet);
            else if (packet instanceof SunlightPacket)
                packetDao.insertSunlightPacket((SunlightPacket) packet);
            else if (packet instanceof CO2Packet)
                packetDao.insertCo2Packet((CO2Packet) packet);
            else if (packet instanceof WaterPacket)
                packetDao.insertWaterPacket((WaterPacket) packet);
            else
                log.warn("未知类型数据！");
        }
    }

    @Override
    public void storeAndPushWeatherData(WeatherPacket packet) {
        Map<String, Object> map = new HashMap<>();
        map.put("weat", packet);
        webSocket.pushPacketsToUsers(map);
        packetDao.insertWeatherPacket(packet);
    }

    @Override
    public void storeAndPushErrorStatusData(ErrorAndStatus status) {
        Map<String, Object> map = new HashMap<>();
        map.put("erro", status);
        webSocket.pushPacketsToUsers(map);
    }
}
