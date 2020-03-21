package com.farm.entity.data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;
/**
 * @Author: Rain
 * @Description: 气象站数据
 * @Date: Created on 2019-05-03 20:36
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class WeatherPacket extends Packet{
    private Integer weatherPacketId;
    //设备id
    private String deviceId;
    private Integer weatherHumidity;
    private Integer weatherTemp;
    private Integer weatherIntensity;
    private Integer ECValue;
    private Integer windSpeed;
    private Integer rainOrSnow;
    private Date commitTime;
    public Integer getWeatherPacketId() {
        return weatherPacketId;
    }
    public void setWeatherPacketId(Integer weatherPacketId) {
        this.weatherPacketId = weatherPacketId;
    }
    public String getDeviceId() {
        return deviceId;
    }
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
    public Integer getWeatherHumidity() {
        return weatherHumidity;
    }
    public void setWeatherHumidity(Integer weatherHumidity) {
        this.weatherHumidity = weatherHumidity;
    }
    public Integer getWeatherTemp() {
        return weatherTemp;
    }
    public void setWeatherTemp(Integer weatherTemp) {
        this.weatherTemp = weatherTemp;
    }
    public Integer getWeatherIntensity() {
        return weatherIntensity;
    }
    public void setWeatherIntensity(Integer weatherIntensity) {
        this.weatherIntensity = weatherIntensity;
    }
    public Integer getECValue() {
        return ECValue;
    }
    public void setECValue(Integer ECValue) {
        this.ECValue = ECValue;
    }
    public Integer getWindSpeed() {
        return windSpeed;
    }
    public void setWindSpeed(Integer windSpeed) {
        this.windSpeed = windSpeed;
    }
    public Integer getRainOrSnow() {
        return rainOrSnow;
    }
    public void setRainOrSnow(Integer rainOrSnow) {
        this.rainOrSnow = rainOrSnow;
    }
    public Date getCommitTime() {
        return commitTime;
    }
    public void setCommitTime(Date commitTime) {
        this.commitTime = commitTime;
    }
}
