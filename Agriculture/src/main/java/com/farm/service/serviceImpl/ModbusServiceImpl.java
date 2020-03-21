package com.farm.service.serviceImpl;
import com.farm.cache.ChannelCache;
import com.farm.constant.FrameConstant;
import com.farm.entity.data.*;
import com.farm.service.ModbusService;
import com.farm.utils.ModbusFrameUtil;
import com.farm.utils.ParseUtil;
import io.netty.channel.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
/**
 * @Author: Rain
 * @Description:
 * @Date: Created on 2019-04-28 20:40
 */
@Service
@SuppressWarnings("noinspection SpellCheckingInspection")
@Slf4j
public class ModbusServiceImpl implements ModbusService {
    @Override
    public void sendLoraDataToPLC(List<Packet> packets) {
        Channel dtuChannel = ChannelCache.getChannelByName("02");
        if (dtuChannel != null) {
            String plcMsg = ModbusFrameUtil.extractFrameFromLora(packets);
            ParseUtil.sendMsgThroughChannel(dtuChannel, plcMsg);
        } else {
            log.info("DTU offline!");
        }
    }
/**
     * 向LED屏发送室内（LORA信息）室外（气象站数据）共用方法
     * @param msg
     *//*
    private void displayLedMsg(String msg) {
        Channel dtuChannel = ChannelCache.getChannelByName("02");
        msg = ParseUtil.encodeToGB2312(msg);
        if (dtuChannel != null) {
            String ledFrame = FrameConstant.LED_FRAME_HEADER + FrameConstant.LED_INTERNAL_CODE1
                    + msg + FrameConstant.LED_INTERNAL_CODE3 + msg + FrameConstant.LED_FRAME_TAIL;
            ParseUtil.sendMsgThroughChannel(dtuChannel, ledFrame);
        }
    }*/
}
