package com.farm.entity.data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;
/**
 * @Author: Rain
 * @Description:
 * @Date: Created on 2018/11/10 14:05
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class WaterPacket extends Packet{
    private Integer waterPacketId;
    private String loraNodeId;
    private String deviceId;
    private Integer dataType;
    private Float waterTemp;
    private Date commitTime;
    public Integer getWaterPacketId() {
        return waterPacketId;
    }
    public void setWaterPacketId(Integer waterPacketId) {
        this.waterPacketId = waterPacketId;
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
    public Float getWaterTemp() {
        return waterTemp;
    }
    public void setWaterTemp(Float waterTemp) {
        this.waterTemp = waterTemp;
    }
    public Date getCommitTime() {
        return commitTime;
    }
    public void setCommitTime(Date commitTime) {
        this.commitTime = commitTime;
    }
}
