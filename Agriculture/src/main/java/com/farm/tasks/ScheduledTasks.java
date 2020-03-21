package com.farm.tasks;
import com.farm.cache.ChannelCache;
import com.farm.constant.FrameConstant;
import com.farm.service.PacketService;
import com.farm.utils.ParseUtil;
import io.netty.channel.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
/**
 * @Author: Rain
 * @Description:
 * @Date: Created on 2019-05-07 19:59
 */
@Component
@Slf4j
public class ScheduledTasks {
    @Autowired
    private PacketService packetService;
    private Channel dtuChannel = null;
    //轮询计数
    private static Integer weather_polling_count = 0;
    private static Integer led_frame_count = 0;
    public static Integer frame_sent_flag = 0;
    @Scheduled(fixedRate = 1000)
    public void pollingForStatus() {
        dtuChannel = ChannelCache.getChannelByName("02");
        if (dtuChannel != null && dtuChannel.isActive()) {
            if (frame_sent_flag == 0) {
                //每60s更新LED屏幕信息
                if (led_frame_count==60) {
                    led_frame_count = 0;
                    String msg = ParseUtil.encodeToGB2312(packetService.assembleLedMsg());
                    String ledFrame = FrameConstant.LED_FRAME_HEADER + FrameConstant.LED_INTERNAL_CODE1
                            + msg + FrameConstant.LED_INTERNAL_CODE3 + msg + FrameConstant.LED_FRAME_TAIL;
                    log.info("weather frame:"+ledFrame);
                    ParseUtil.sendMsgThroughChannel(dtuChannel, ledFrame);
                    //每180s向PLC轮询气象站信息
                } else if (weather_polling_count == 180) {
                    weather_polling_count = 0;
                    log.info("weatherData: " + FrameConstant.READ_WEATHER_DATA);
                    ParseUtil.sendMsgThroughChannel(dtuChannel, FrameConstant.READ_WEATHER_DATA);
                }   else {
                    //每秒轮询
                    weather_polling_count++;
                    led_frame_count++;
                    ParseUtil.sendMsgThroughChannel(dtuChannel, FrameConstant.READ_ERROR_STATUS);
                }
            }
        }
    }
}
