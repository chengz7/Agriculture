package com.farm.constant;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: Rain
 * @Description: 项目中用到了很多静态变量作为条件用来实现达到某种条件做某事的逻辑，把这些静态变量
 * 都放到这个类中，存放的是静态变量，不是静态常量
 * @Date: Created on 2019-05-19 18:27
 */
public class StaticVariable {


    /**
     * LED点阵屏显示信息
     * 室内：二合一0003的  温度 湿度 土壤湿度  二氧化碳  光照  水温
     *
     */
    public static volatile ConcurrentHashMap<String, String> LedDataMap = new ConcurrentHashMap<>();

}
