package com.farm.entity.data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;
/**
 * @Author: Rain
 * @Description:
 * @Date: Created on 2018/11/10 13:20
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class CO2Packet extends Packet{
    private Integer CO2PacketId;
    private String loraNodeId;
    private String deviceId;
    private Integer dataType;
    //co2浓度
    private Float concentration;
    private Date commitTime;
    public Integer getCO2PacketId() {
        return CO2PacketId;
    }
    public void setCO2PacketId(Integer CO2PacketId) {
        this.CO2PacketId = CO2PacketId;
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
    public Float getConcentration() {
        return concentration;
    }
    public void setConcentration(Float concentration) {
        this.concentration = concentration;
    }
    public Date getCommitTime() {
        return commitTime;
    }
    public void setCommitTime(Date commitTime) {
        this.commitTime = commitTime;
    }
}
