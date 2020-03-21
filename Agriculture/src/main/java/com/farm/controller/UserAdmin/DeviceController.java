package com.farm.controller.UserAdmin;

import com.farm.cache.ChannelCache;
import com.farm.constant.FrameConstant;
import com.farm.entity.ControlFrame;
import com.farm.entity.Info;
import com.farm.service.DeviceService;
import com.farm.tasks.ScheduledTasks;
import com.farm.utils.ParseUtil;
import io.netty.channel.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Rain
 * @Description:
 * @Date: Created on 2019-05-04 21:39
 */
@RestController
@RequestMapping("/device")
@Slf4j
public class DeviceController {

    @Autowired
    private DeviceService deviceService;


    /**
     * 用于急停
     * @param id
     * @return
     */
    @GetMapping("/stop/{id}")
    public Map<String, Object> stopAll(@PathVariable("id") Integer id) throws InterruptedException{
        Map<String, Object> map = new HashMap<>();
        ControlFrame frame = deviceService.getFrame(id);
        //162急停开，163急停关
        String stopFrame = id == 162 ? frame.getCode1() : frame.getCode0();
        ScheduledTasks.frame_sent_flag = 1;
        Thread.sleep(1000);
        deviceService.stopAll(stopFrame);
        Thread.sleep(1000);
        ScheduledTasks.frame_sent_flag = 0;

        return map;
    }

    /**
     * 前端控制帧下发
     * @param info
     * @return
     */
    @PostMapping("/device_control")
    public Map<String, Object> controlDevice(@RequestBody ControlFrame info) throws InterruptedException {
        Map<String, Object> modelMap = new HashMap<>();
        ControlFrame frame = deviceService.getFrame(info.getId());

        ScheduledTasks.frame_sent_flag = 1;
        Thread.sleep(1000);
        deviceService.sendFrame(frame);
        Thread.sleep(1000);
        ScheduledTasks.frame_sent_flag = 0;

        return modelMap;
    }

    /**
     * 移动端控制帧下发
     * @param id
     * @return
     */
    @GetMapping("/device_control_mobile/{id}")
    public Map<String, Object> controlDeviceMobile(@PathVariable("id") Integer id) throws InterruptedException {
        Map<String, Object> modelMap = new HashMap<>();
        ControlFrame frame = deviceService.getFrame(id);

        ScheduledTasks.frame_sent_flag = 1;
        Thread.sleep(1000);
        deviceService.sendFrame(frame);
        Thread.sleep(1000);
        ScheduledTasks.frame_sent_flag = 0;

        return modelMap;
    }

    /**
     * @param info
     */
    @PostMapping("/led_display")
    public void ledDisplay(@RequestBody Info info ) {
        Channel dtuChannel = ChannelCache.getChannelByName("02");
        String msg = info.getMsg_up();
        log.info(info.toString());
        if (msg != null && dtuChannel != null && dtuChannel.isActive()) {
            msg = ParseUtil.encodeToGB2312(msg);
            String ledFrame = FrameConstant.LED_FRAME_HEADER + FrameConstant.LED_INTERNAL_CODE0
                    + msg + FrameConstant.LED_INTERNAL_CODE2 + msg + FrameConstant.LED_FRAME_TAIL;
            log.info(ledFrame);
            ParseUtil.sendMsgThroughChannel(dtuChannel, ledFrame);
        }
    }





}
