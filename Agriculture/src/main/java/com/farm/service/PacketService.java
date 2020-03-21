package com.farm.service;
import com.farm.entity.data.Packet;
import java.util.List;
/**
 * @Author: Rain
 * @Description:
 * @Date: Created on 2019-06-11 10:07
 */
public interface PacketService {
    List<Packet> getInitPackets();
    String assembleLedMsg();
}
