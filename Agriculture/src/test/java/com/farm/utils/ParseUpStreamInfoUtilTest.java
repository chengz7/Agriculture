package com.farm.utils;

import com.farm.entity.ErrorAndStatus;
import com.farm.entity.data.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: Rain
 * @Description:
 * @Date: Created on 2018/11/11 18:38
 */
@Slf4j
public class ParseUpStreamInfoUtilTest {

    @Test
    public void test2() {
        String data = "010316000100000008000000000000000000000000000000003770";
        data = data.substring(6, 50);
        String binaryStr = ParseUtil.strToBinStr(data);
        System.out.println(binaryStr);
        for (int i = 0; i < binaryStr.length(); i++) {
            System.out.println(i+" : "+binaryStr.charAt(i));
        }
    }

    @Test
    /**
     * 010316 0001 0000 0008 0000 0000 0000 0000 0000 0000 0000 0000 3770
     * 0000000000000001
     * 0000000000000000
     * 0000000000001000
     * 0000000000000000
     * 0000000000000000
     * 0000000000000000
     * 0000000000000000
     * 0000000000000000
     * 0000000000000000
     * 0000000000000000
     * 0000000000000000
     */
    public void testErrorAndStatus() {
        String data = "010316000100000008000000000000000000000000000000003770";
        ErrorAndStatus errorAndStatus = ParseUpStreamInfoUtil.parseErrorAndFeedbackStatusData(data);
        System.out.println(errorAndStatus);
    }

    @Test
    public void testValidate() {
        String data = "010600000001";
        System.out.println(CRCValidationUtil.CRC16Validate(data));
    }

    @Test
    public void validateInfo() {
        String hexData = "fffe150a070000000000022f390083960100000000001f0d";
        assertFalse(ParseUpStreamInfoUtil.isValidInfo(hexData));
    }

    @Test
    public void testHandleData() {
        String hexData = "fffe1a0a07000500000001073900858b0200525f41020152000000a566";
        List<Packet> packets = ParseUpStreamInfoUtil.parseGatewayPackets(hexData);

    }

    @Test
    public void test() {
        int i = 9;
        switch(i){
            case 0:
                System.out.println("0");
                break;
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            case 3:
                System.out.println("3");
                break;
            default:
                System.out.println("default");
                break;
        }
    }


}