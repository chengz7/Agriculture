package com.farm.service.serviceImpl;

import com.farm.InitApplication;
import com.farm.entity.data.Packet;
import com.farm.service.PacketService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: Rain
 * @Description:
 * @Date: Created on 2019-06-11 10:46
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = InitApplication.class,webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class PacketServiceImplTest {

    @Autowired
    private PacketService packetService;

    @Test
    public void getInitPackets() {
        List<Packet> initPackets = packetService.getInitPackets();
    }
}