package com.farm.entity.data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;
/**
 * @Author: Rain
 * @Description:
 * @Date: Created on 2018/11/10 13:18
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class SunlightPacket extends Packet{
    private Integer sunlightPacketId;
    private String loraNodeId;
    private String deviceId;
    private Integer dataType;
    //日照强度
    private Float intensity;
    private Date commitTime;
    public Integer getSunlightPacketId() {
        return sunlightPacketId;
    }
    public void setSunlightPacketId(Integer sunlightPacketId) {
        this.sunlightPacketId = sunlightPacketId;
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
    public Float getIntensity() {
        return intensity;
    }
    public void setIntensity(Float intensity) {
        this.intensity = intensity;
    }
    public Date getCommitTime() {
        return commitTime;
    }
    public void setCommitTime(Date commitTime) {
        this.commitTime = commitTime;
    }
}
