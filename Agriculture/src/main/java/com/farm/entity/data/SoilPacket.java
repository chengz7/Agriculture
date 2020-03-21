package com.farm.entity.data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;
/**
 * @Author: Rain
 * @Description:
 * @Date: Created on 2018/11/10 13:12
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class SoilPacket extends Packet{
    private Integer soilPacketId;
    private String loraNodeId;
    private String deviceId;
    private Integer dataType;
    //土壤温度
    private Float soilTemp;
    //土壤水分/湿度
    private Float soilHumidity;
    private Date commitTime;
    public Integer getSoilPacketId() {
        return soilPacketId;
    }
    public void setSoilPacketId(Integer soilPacketId) {
        this.soilPacketId = soilPacketId;
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
    public Float getSoilTemp() {
        return soilTemp;
    }
    public void setSoilTemp(Float soilTemp) {
        this.soilTemp = soilTemp;
    }
    public Float getSoilHumidity() {
        return soilHumidity;
    }
    public void setSoilHumidity(Float soilHumidity) {
        this.soilHumidity = soilHumidity;
    }
    public Date getCommitTime() {
        return commitTime;
    }
    public void setCommitTime(Date commitTime) {
        this.commitTime = commitTime;
    }
}
