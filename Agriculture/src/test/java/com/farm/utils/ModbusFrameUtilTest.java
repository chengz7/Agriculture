package com.farm.utils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author: Rain
 * @Description:
 * @Date: Created on 2019-04-28 22:11
 */
public class ModbusFrameUtilTest {

    @Test
    public void floatToIntString() {
        System.out.println(ModbusFrameUtil.floatToIntString(new Float(2.04)));
    }
    @Test
    public void test() {
        StringBuilder s = new StringBuilder();
        String s1 = s.toString();
        System.out.println(s1.equals("null"));
    }
}