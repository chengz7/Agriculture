package com.farm.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: Rain
 * @Description: 用于缓存指令帧，减小数据库访问压力。
 * @Date: Created on 2019-04-25 21:21
 */
public class FrameCache {




    /**
     * 控制设备写入请求帧，由于一个控制设备涉及到两个写请求两个应答帧，以外遮阳电机1正转请求帧为例：
     * 置1写入请求帧 -> 置1写入应答帧 -> 置0写入请求帧 -> 置0写入应答帧
     * 采用先发 置1写入应答帧， 再发 置0写入请求帧
     * key:frameName value:writecode
     */
    public static Map<String, String> controlFrameMap = new ConcurrentHashMap<>();
}
