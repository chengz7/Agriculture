package com.farm.entity.data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
/**
 * @Author: Rain
 * @Description:
 * @Date: Created on 2018/11/10 14:07
 */
@Getter
@Setter
@NoArgsConstructor
public class ECPacket extends Packet{
    private Integer soilPacketId;
    private String loraNodeId;
    private String deviceId;
    private Integer dataType;
    private Float ECValue;
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
    public Float getECValue() {
        return ECValue;
    }
    public void setECValue(Float ECValue) {
        this.ECValue = ECValue;
    }
    public Date getCommitTime() {
        return commitTime;
    }
    public void setCommitTime(Date commitTime) {
        this.commitTime = commitTime;
    }
}
