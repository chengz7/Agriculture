package com.farm.service;
import com.farm.entity.ControlFrame;
/**
 * @Author: Rain
 * @Description: 设备以及控制帧的获取
 * @Date: Created on 2019-05-07 14:53
 */
public interface DeviceService {
    ControlFrame getFrame(Integer frameId);
    void sendFrame(ControlFrame frame);
    void stopAll(String frame);
}
