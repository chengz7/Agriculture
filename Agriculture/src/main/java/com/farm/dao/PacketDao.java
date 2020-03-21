package com.farm.dao;
import com.farm.entity.data.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
/**
 * @Author: Rain
 * @Description:
 * @Date: Created on 2018/11/1 21:31
 */
@Repository
public interface PacketDao {
    int insertAirPacket(@Param("packet") AirPacket packet);
    int insertSoilPacket(@Param("packet")SoilPacket packet);
    int insertSunlightPacket(@Param("packet")SunlightPacket packet);
    int insertCo2Packet(@Param("packet")CO2Packet packet);
    int insertWaterPacket(@Param("packet") WaterPacket packet);
    int insertWeatherPacket(@Param("packet") WeatherPacket packet);
    /*SELECT * FROM `air_record` where device_id = '1b6400' ORDER BY commit_time DESC LIMIT 1*/
    AirPacket getLatestAirPacketById(@Param("deviceId") String deviceId);
    SoilPacket getLatestSoilPacketById(@Param("deviceId") String deviceId);
    SunlightPacket getLatestSunlightPacketById(@Param("deviceId") String deviceId);
    CO2Packet getLatestCo2PacketById(@Param("deviceId") String deviceId);
    WaterPacket getLatestWaterPacketById(@Param("deviceId") String deviceId);
    /*SELECT * FROM `weather_record` WHERE id in (SELECT MAX(id) FROM `weather_record`);*/
    WeatherPacket getLatestWeatherPacketById(@Param("deviceId") String deviceId);
}
