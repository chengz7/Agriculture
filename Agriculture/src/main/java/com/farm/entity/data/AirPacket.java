package com.farm.entity.data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;
/**
 * @Author: Rain
 * @Description: 空气温湿度
 * @Date: Created on 2018/11/10 13:04
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class AirPacket extends Packet{
    private Integer airPacketId;
    //lora节点id
    private String loraNodeId;
    //lora节点id加上设备类型构成设备id
    //设备类型就可以确定数据名称
    private String deviceId;
    //数据类型，按照协议类型一一对应
    private Integer dataType;
    //空气温度数据
    private Float airTemp;
    //空气湿度
    private Float airHumidity;
    private Date commitTime;
    public Integer getAirPacketId() {
        return airPacketId;
    }
    public void setAirPacketId(Integer airPacketId) {
        this.airPacketId = airPacketId;
    }
    public String getLoraNodeId() {
        return loraNodeId;
    }
    public void setLoraNodeId(String loraNodeId) {
        this.loraNodeId = loraNodeId;
    }
    public String getDeviceId() {
        return deviceId;
    }
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
    public Integer getDataType() {
        return dataType;
    }
    public void setDataType(Integer dataType) {
        this.dataType = dataType;
    }
    public Float getAirTemp() {
        return airTemp;
    }
    public void setAirTemp(Float airTemp) {
        this.airTemp = airTemp;
    }
    public Float getAirHumidity() {
        return airHumidity;
    }
    public void setAirHumidity(Float airHumidity) {
        this.airHumidity = airHumidity;
    }
    public Date getCommitTime() {
        return commitTime;
    }
    public void setCommitTime(Date commitTime) {
        this.commitTime = commitTime;
    }
}
