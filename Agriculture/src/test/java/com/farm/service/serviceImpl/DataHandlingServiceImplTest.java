package com.farm.service.serviceImpl;

import com.farm.entity.data.AirPacket;
import com.farm.entity.data.Packet;
import com.farm.entity.data.SoilPacket;
import com.farm.service.DataHandlingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: Rain
 * @Description: 测试遇到加载问题可以注释WebSocketConfig的@Bean以及 myServer.run(8765);不运行netty
 * @Date: Created on 2018/11/10 16:35
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DataHandlingServiceImplTest {

    @Autowired
    private DataHandlingService handlingService;

    @Test
    public void storeAndPushData() {
        List<Packet> packets = new ArrayList<>();
        AirPacket packet = new AirPacket();
        packet.setLoraNodeId("1b66");
        packet.setDeviceId("1b6600");
        packet.setDataType(0);
        packet.setAirTemp((float) 20.7);
        packet.setAirHumidity((float) 52.1);
        packet.setCommitTime(new Date());
        SoilPacket soilPacket = new SoilPacket();
        soilPacket.setLoraNodeId("1b66");
        soilPacket.setDeviceId("1b6601");
        soilPacket.setDataType(1);
        soilPacket.setSoilTemp((float) 20);
        soilPacket.setSoilHumidity((float) 0);
        soilPacket.setCommitTime(new Date());
        packets.add(packet);
        packets.add(soilPacket);
        handlingService.storeAndPushData(packets);
    }
}