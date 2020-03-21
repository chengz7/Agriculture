package com.farm.service.serviceImpl;
import com.farm.cache.ChannelCache;
import com.farm.dao.DeviceDao;
import com.farm.entity.ControlFrame;
import com.farm.service.DeviceService;
import com.farm.utils.ParseUtil;
import io.netty.channel.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
/**
 * @Author: Rain
 * @Description:
 * @Date: Created on 2019-05-07 15:01
 */
@Service
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    private DeviceDao deviceDao;
    @Override
    public ControlFrame getFrame(Integer frameId) {
        return deviceDao.findFrameById(frameId);
    }
    @Override
    public void sendFrame(ControlFrame frame) {
        Channel dtuChannel = ChannelCache.getChannelByName("02");
        if (dtuChannel != null && dtuChannel.isActive()) {
            ParseUtil.sendMsgThroughChannel(dtuChannel,frame.getCode1());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ParseUtil.sendMsgThroughChannel(dtuChannel,frame.getCode0());
        }
    }
    @Override
    public void stopAll(String frame) {
        Channel dtuChannel = ChannelCache.getChannelByName("02");
        if (dtuChannel != null && dtuChannel.isActive()) {
            ParseUtil.sendMsgThroughChannel(dtuChannel,frame);
        }
    }
}
