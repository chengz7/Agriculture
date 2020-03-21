package com.farm.utils;

import com.farm.entity.data.WeatherPacket;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.math.BigInteger;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @Author: Rain
 * @Description:
 * @Date: Created on 2019-05-04 19:53
 */
@Slf4j
public class ParseUtilTest {

    @Test
    public void testLength() {
        String message = "fffe240a071b64000000010b270085790400525c411d015200000002000a00000303180000a406";
        boolean flag = true;
        if (message != null && !message.isEmpty()) {
            if (message.length() < 6) {
                flag = false;
            } else {
                int l = ParseUtil.hexStringToInt(message.substring(4, 6))*2+6;
                if (l != message.length()) {
                    flag=false;
                }
            }
            if (!flag) {
                log.warn("wrong msg:" + message);
            }
            log.info(message);
        }
    }



    @Test
    public void encode() {
        String msg = ParseUtil.encodeToGB2312("内码区0");
        System.out.println(msg);
    }

    @Test
    public void hexStringToInt() {
        //System.out.println(ParseUtil.hexStringToInt("00FA"));
        float a = 24.38f;
        int b = (int) a;
        System.out.println(b);
    }

    @Test
    public void parseWeatherDataFromDtuTest() {
        String hexData = "01031800FA00FA00000000000000000000000000640000003F00010334";
        WeatherPacket packet = ParseUpStreamInfoUtil.parseWeatherPacket(hexData);
        System.out.println(packet);
    }

    @Test
    public void hexStringToBytesTest() {
        String hexData = "ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff";
        byte[] bytes = ParseUtil.hexStringToBytes(hexData);
        String s = new BigInteger(1, bytes).toString(2);
        System.out.println(s);
    }
}