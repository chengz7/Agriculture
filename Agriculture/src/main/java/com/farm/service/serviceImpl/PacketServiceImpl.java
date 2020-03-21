package com.farm.service.serviceImpl;
import com.farm.dao.PacketDao;
import com.farm.entity.data.*;
import com.farm.service.PacketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
/**
 * @Author: Rain
 * @Description:
 * @Date: Created on 2019-06-11 10:09
 */
@Service
@Slf4j
public class PacketServiceImpl implements PacketService {
    @Autowired
    private PacketDao packetDao;
    @Override
    public List<Packet> getInitPackets() {
        List<Packet> list = new ArrayList<>();
        list.add(packetDao.getLatestAirPacketById("03b700"));
        list.add(packetDao.getLatestSoilPacketById("03b701"));
        list.add(packetDao.getLatestSunlightPacketById("03b702"));
        list.add(packetDao.getLatestCo2PacketById("03b703"));
        list.add(packetDao.getLatestAirPacketById("000100"));
        list.add(packetDao.getLatestWaterPacketById("03b613"));
        list.add(packetDao.getLatestAirPacketById("000300"));
        list.add(packetDao.getLatestSoilPacketById("000301"));
        list.add(packetDao.getLatestAirPacketById("000400"));
        list.add(packetDao.getLatestSoilPacketById("000401"));
        list.add(packetDao.getLatestAirPacketById("000500"));
        list.add(packetDao.getLatestSoilPacketById("000501"));
        list.add(packetDao.getLatestWeatherPacketById("000004"));
        return list;
    }
    @Override
    public String assembleLedMsg() {
        //室外
        WeatherPacket weatherPacket = packetDao.getLatestWeatherPacketById("000004");
        //室内
        //空气温湿度
        AirPacket airPacket = packetDao.getLatestAirPacketById("000100");
        //土壤
        SoilPacket soilPacket = packetDao.getLatestSoilPacketById("000301");
        //水温
        WaterPacket waterPacket = packetDao.getLatestWaterPacketById("03b613");
        //光照
        SunlightPacket sunlightPacket = packetDao.getLatestSunlightPacketById("03b702");
        //co2
        CO2Packet co2Packet = packetDao.getLatestCo2PacketById("03b703");
        StringBuilder msg = new StringBuilder();
        msg = msg.append("室外:温度").append(weatherPacket.getWeatherTemp()).append("℃")
                .append("湿度").append(weatherPacket.getWeatherHumidity()).append("%")
                .append("风速:").append(weatherPacket.getWindSpeed()).append("m/s")
                .append("光照:").append(weatherPacket.getWeatherIntensity()).append("klux")
                .append(weatherPacket.getRainOrSnow()==0?"无降水":"有降水")
                .append(" 室内:温度").append((int) airPacket.getAirTemp().floatValue()).append("℃")
                .append("湿度:").append((int) airPacket.getAirHumidity().floatValue()).append("%")
                .append("土壤湿度:").append((int) soilPacket.getSoilHumidity().floatValue()).append("%")
                .append("水温:").append((int) waterPacket.getWaterTemp().floatValue()).append("℃")
                .append("光照:").append(sunlightPacket.getIntensity()).append("klux")
                .append("二氧化碳:").append((int) co2Packet.getConcentration().floatValue()).append("PPM");
        log.info("led msg"+msg);
        return msg.toString();
    }
}
