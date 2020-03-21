package com.farm.utils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author: Rain
 * @Description:
 * @Date: Created on 2019-04-29 16:30
 */
public class CRCValidationUtilTest {

    @Test
    public void CRC16ValidateForModbus() {

        System.out.println(CRCValidationUtil.CRC16Validate("010307D1000C"));
        System.out.println(CRCValidationUtil.CRC16ValidateForModbus("010307D1000C"));

    }
    @Test
    public void CRC16Validate() {

        String msg = "8214";
        System.out.println(msg.substring(2));
        System.out.println(msg.substring(0,2));
    }

    @Test
    public void testCRC() {

    }
}