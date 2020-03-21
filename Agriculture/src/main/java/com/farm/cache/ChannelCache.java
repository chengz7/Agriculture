package com.farm.cache;

import com.farm.constant.TransmissionConstant;
import io.netty.channel.Channel;
import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: Rain
 * @Description: 使用ConcurrentHashMap 缓存channel
 * @Date: Created on 2019-04-25 21:15
 */
@Slf4j
public class ChannelCache {

    private static Map<String, Channel> channelMap = new ConcurrentHashMap<>();

    /**
     * 01 服务器与Lora网关的channel
     * 02 服务器与DTU的channel
     * @param channelName 00/01
     * @return
     */
    public static Channel getChannelByName(String channelName) {
        if (channelMap.containsKey(channelName)) {
            return channelMap.get(channelName);
        } else {
            return null;
        }
    }

    /**
     * 添加channel
     * @param channel
     */
    @Deprecated
    public static void addChannel(Channel channel) {
        if (channelMap.containsValue(channel)) {
            return;
        }
        InetSocketAddress address = (InetSocketAddress) channel.remoteAddress();
        String ipAddress  = address.getAddress().getHostAddress();
        channelMap.put(ipAddress, channel);
        if (ipAddress.equals(TransmissionConstant.LORA_GATE_IP)) {
            log.info(ipAddress+" 01 connected!");
            channelMap.put("01", channel);
        } else {
            log.info(ipAddress+" 02 connected!");
            channelMap.put("02", channel);
        }
    }

    public static void addChannel(String key, Channel channel) {
        InetSocketAddress address = (InetSocketAddress) channel.remoteAddress();
        String ipAddress  = address.getAddress().getHostAddress();
        log.info(ipAddress+" "+ key +" : connected!");
        channelMap.put(key, channel);
    }

    public static void removeChannel(Channel channel) {
        if (channelMap.containsValue(channel)) {
            if (channel==channelMap.get("01")) {
                channelMap.remove("01");
            } else {
                channelMap.remove("02");
            }
        }
    }



}
