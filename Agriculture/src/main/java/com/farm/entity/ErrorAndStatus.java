package com.farm.entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/**
 * @Author: Rain
 * @Description: 对于故障信息检测：true代表有故障，false代表无故障；
 * 对于反馈状态检测：true代表操作有反馈，false代表无反馈
 * @Date: Created on 2019-05-05 9:37
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
@SuppressWarnings("noinspection SpellCheckingInspection")
public class ErrorAndStatus {
    private Boolean WaiZheYang1_MotorFault;
    private Boolean WaiZheYang2_MotorFault;
    private Boolean NeiZheYang1_MotorFault;
    private Boolean NeiZheYang2_MotorFault;
    private Boolean FengJi1_SwitchMotorFault;
    private Boolean FengJi2_SwitchMotorFault;
    private Boolean FengJi3_SwitchMotorFault;
    private Boolean GuanGaiShuiBeng_SwitchMotorFault;
    private Boolean ShuiPeiShuiBeng_SwitchMotorFault;
    private Boolean ShiFeiBeng_SwitchMotorFault;
    private Boolean ZengYangJi_SwitchMotorFault;
    private Boolean ReFengJi_SwitchMotorFault;
    private Boolean ZhaoMing1_SwitchMotorFault;
    private Boolean ZhaoMing2_SwitchMotorFault;
    private Boolean LED_SwitchMotorFault;
    private Boolean DingTongFeng_MotorFault;
    private Boolean WaiZheYang1_Forward_Feedback_Fault_Output;
    private Boolean WaiZheYang1_Reverse_Feedback_Fault_Output;
    private Boolean WaiZheYang2_Forward_Feedback_Fault_Output;
    private Boolean WaiZheYang2_Reverse_Feedback_Fault_Output;
    private Boolean NeiZheYang1_Forward_Feedback_Fault_Output;
    private Boolean NeiZheYang1_Reverse_Feedback_Fault_Output;
    private Boolean NeiZheYang2_Forward_Feedback_Fault_Output;
    private Boolean NeiZheYang2_Reverse_Feedback_Fault_Output;
    private Boolean FengJi1_Feedback_Fault_Output;
    private Boolean FengJi2_Feedback_Fault_Output;
    private Boolean FengJi3_Feedback_Fault_Output;
    private Boolean GuanGaiShuiBeng_Feedback_Fault_Output;
    private Boolean ShuiPeiShuiBeng_Feedback_Fault_Output;
    private Boolean ShiFeiBeng_Feedback_Fault_Output;
    private Boolean ZengYangJi_Feedback_Fault_Output;
    private Boolean ReFengJi_Feedback_Fault_Output;
    private Boolean ZhaoMing1_Feedback_Fault_Output;
    private Boolean ZhaoMing2_Feedback_Fault_Output;
    private Boolean LED_Feedback_Fault_Output;
    private Boolean DingTongFeng_Forward_Feedback_Fault_Output;
    private Boolean DingTongFeng_Reverse_Feedback_Fault_Output;
    //总故障
    private Boolean FengMingQi;
    private Boolean Remote_Local_Control;
    private Boolean ShuiLian_SwitchMotorFault;
    private Boolean ShuiLian_Feedback_Fault_Output;
    private Boolean Emergency_Stop_State;
    private Boolean WaiZheYang1_Forward_FeedBack;
    private Boolean WaiZheYang1_Reverse_FeedBack;
    private Boolean WaiZheYang2_Forward_FeedBack;
    private Boolean WaiZheYang2_Reverse_FeedBack;
    private Boolean NeiZheYang1_Forward_FeedBack;
    private Boolean NeiZheYang1_Reverse_FeedBack;
    private Boolean NeiZheYang2_Forward_FeedBack;
    private Boolean NeiZheYang2_Reverse_FeedBack;
    private Boolean FengJi1_FeedBack;
    private Boolean FengJi2_FeedBack;
    private Boolean FengJi3_FeedBack;
    private Boolean GuanGaiShuiBeng_FeedBack;
    private Boolean ShuiPeiShuiBeng_FeedBack;
    private Boolean ShiFeiBeng_FeedBack;
    private Boolean ZengYangJi_FeedBack;
    private Boolean ReFengJi_FeedBack;
    private Boolean ZhaoMing1_FeedBack;
    private Boolean ZhaoMing2_FeedBack;
    private Boolean LED_FeedBack;
    private Boolean DingTongFeng_Forward_FeedBack;
    private Boolean DingTongFeng_Reverse_FeedBack;
    private Boolean ShuiLianBuShui_ElectromagneticValveOutput;
    private Boolean ShuiChiBuShui_ElectromagneticValveOutput;
    private Boolean MiaoChuangGuanGai1_ElectromagneticValveOutput;
    private Boolean MiaoChuangGuanGai2_ElectromagneticValveOutput;
    private Boolean MiaoChuangGuanGai3_ElectromagneticValveOutput;
    private Boolean MiaoChuangGuanGai4_ElectromagneticValveOutput;
    private Boolean MiaoChuangGuanGai5_ElectromagneticValveOutput;
    private Boolean MiaoChuangGuanGai6_ElectromagneticValveOutput;
    private Boolean MiaoChuangGuanGai7_ElectromagneticValveOutput;
    private Boolean MiaoChuangGuanGai8_ElectromagneticValveOutput;
    private Boolean MiaoChuangGuanGai9_ElectromagneticValveOutput;
    private Boolean MiaoChuangGuanGai10_ElectromagneticValveOutput;
    private Boolean MiaoChuangGuanGai11_ElectromagneticValveOutput;
    private Boolean MiaoChuangGuanGai12_ElectromagneticValveOutput;
    private Boolean MiaoChuangGuanGai13_ElectromagneticValveOutput;
    private Boolean MiaoChuangGuanGai14_ElectromagneticValveOutput;
    private Boolean MiaoChuangGuanGai15_ElectromagneticValveOutput;
    private Boolean MiaoChuangGuanGai16_ElectromagneticValveOutput;
    private Boolean MiaoChuangGuanGai17_ElectromagneticValveOutput;
    private Boolean MiaoChuangGuanGai18_ElectromagneticValveOutput;
    private Boolean MiaoChuangGuanGai19_ElectromagneticValveOutput;
    private Boolean MiaoChuangGuanGai20_ElectromagneticValveOutput;
    private Boolean MiaoChuangGuanGai21_ElectromagneticValveOutput;
    private Boolean MiaoChuangGuanGai22_ElectromagneticValveOutput;
    private Boolean MiaoChuangGuanGai23_ElectromagneticValveOutput;
    private Boolean MiaoChuangGuanGai24_ElectromagneticValveOutput;
    private Boolean MiaoChuangGuanGai25_ElectromagneticValveOutput;
    private Boolean MiaoChuangGuanGai26_ElectromagneticValveOutput;
    private Boolean MiaoChuangGuanGai27_ElectromagneticValveOutput;
    private Boolean MiaoChuangGuanGai28_ElectromagneticValveOutput;
    private Boolean MiaoChuangGuanGai29_ElectromagneticValveOutput;
    private Boolean MiaoChuangGuanGai30_ElectromagneticValveOutput;
    private Boolean MiaoChuangGuanGai31_ElectromagneticValveOutput;
    private Boolean MiaoChuangGuanGai32_ElectromagneticValveOutput;
    private Boolean MiaoChuangGuanGai33_ElectromagneticValveOutput;
    private Boolean MiaoChuangGuanGai34_ElectromagneticValveOutput;
    private Boolean MiaoChuangGuanGai35_ElectromagneticValveOutput;
    private Boolean MiaoChuangGuanGai36_ElectromagneticValveOutput;
    private Boolean MiaoChuangGuanGai37_ElectromagneticValveOutput;
    private Boolean MiaoChuangGuanGai38_ElectromagneticValveOutput;
    private Boolean MiaoChuangGuanGai39_ElectromagneticValveOutput;
    private Boolean MiaoChuangGuanGai40_ElectromagneticValveOutput;
    private Boolean MiaoChuangGuanGai41_ElectromagneticValveOutput;
    private Boolean MiaoChuangGuanGai42_ElectromagneticValveOutput;
    private Boolean MiaoChuangGuanGai43_ElectromagneticValveOutput;
    private Boolean MiaoChuangGuanGai44_ElectromagneticValveOutput;
    private Boolean MiaoChuangGuanGai45_ElectromagneticValveOutput;
    private Boolean MiaoChuangGuanGai46_ElectromagneticValveOutput;
    private Boolean MiaoChuangGuanGai47_ElectromagneticValveOutput;
    private Boolean MiaoChuangGuanGai48_ElectromagneticValveOutput;
    private Boolean MiaoChuangGuanGai49_ElectromagneticValveOutput;
    private Boolean MiaoChuangGuanGai50_ElectromagneticValveOutput;
    private Boolean MiaoChuangGuanGai51_ElectromagneticValveOutput;
    private Boolean MiaoChuangGuanGai52_ElectromagneticValveOutput;
    private Boolean MiaoChuangGuanGai53_ElectromagneticValveOutput;
    private Boolean MiaoChuangGuanGai54_ElectromagneticValveOutput;
    private Boolean MiaoChuangGuanGai55_ElectromagneticValveOutput;
    private Boolean MiaoChuangGuanGai56_ElectromagneticValveOutput;
    private Boolean MiaoChuangGuanGai57_ElectromagneticValveOutput;
    private Boolean MiaoChuangGuanGai58_ElectromagneticValveOutput;
    private Boolean MiaoChuangGuanGai59_ElectromagneticValveOutput;
    private Boolean MiaoChuangGuanGai60_ElectromagneticValveOutput;
    private Boolean ShuiLian_FeedBack;
    public Boolean getWaiZheYang1_MotorFault() {
        return WaiZheYang1_MotorFault;
    }
    public void setWaiZheYang1_MotorFault(Boolean waiZheYang1_MotorFault) {
        WaiZheYang1_MotorFault = waiZheYang1_MotorFault;
    }
    public Boolean getWaiZheYang2_MotorFault() {
        return WaiZheYang2_MotorFault;
    }
    public void setWaiZheYang2_MotorFault(Boolean waiZheYang2_MotorFault) {
        WaiZheYang2_MotorFault = waiZheYang2_MotorFault;
    }
    public Boolean getNeiZheYang1_MotorFault() {
        return NeiZheYang1_MotorFault;
    }
    public void setNeiZheYang1_MotorFault(Boolean neiZheYang1_MotorFault) {
        NeiZheYang1_MotorFault = neiZheYang1_MotorFault;
    }
    public Boolean getNeiZheYang2_MotorFault() {
        return NeiZheYang2_MotorFault;
    }
    public void setNeiZheYang2_MotorFault(Boolean neiZheYang2_MotorFault) {
        NeiZheYang2_MotorFault = neiZheYang2_MotorFault;
    }
    public Boolean getFengJi1_SwitchMotorFault() {
        return FengJi1_SwitchMotorFault;
    }
    public void setFengJi1_SwitchMotorFault(Boolean fengJi1_SwitchMotorFault) {
        FengJi1_SwitchMotorFault = fengJi1_SwitchMotorFault;
    }
    public Boolean getFengJi2_SwitchMotorFault() {
        return FengJi2_SwitchMotorFault;
    }
    public void setFengJi2_SwitchMotorFault(Boolean fengJi2_SwitchMotorFault) {
        FengJi2_SwitchMotorFault = fengJi2_SwitchMotorFault;
    }
    public Boolean getFengJi3_SwitchMotorFault() {
        return FengJi3_SwitchMotorFault;
    }
    public void setFengJi3_SwitchMotorFault(Boolean fengJi3_SwitchMotorFault) {
        FengJi3_SwitchMotorFault = fengJi3_SwitchMotorFault;
    }
    public Boolean getGuanGaiShuiBeng_SwitchMotorFault() {
        return GuanGaiShuiBeng_SwitchMotorFault;
    }
    public void setGuanGaiShuiBeng_SwitchMotorFault(Boolean guanGaiShuiBeng_SwitchMotorFault) {
        GuanGaiShuiBeng_SwitchMotorFault = guanGaiShuiBeng_SwitchMotorFault;
    }
    public Boolean getShuiPeiShuiBeng_SwitchMotorFault() {
        return ShuiPeiShuiBeng_SwitchMotorFault;
    }
    public void setShuiPeiShuiBeng_SwitchMotorFault(Boolean shuiPeiShuiBeng_SwitchMotorFault) {
        ShuiPeiShuiBeng_SwitchMotorFault = shuiPeiShuiBeng_SwitchMotorFault;
    }
    public Boolean getShiFeiBeng_SwitchMotorFault() {
        return ShiFeiBeng_SwitchMotorFault;
    }
    public void setShiFeiBeng_SwitchMotorFault(Boolean shiFeiBeng_SwitchMotorFault) {
        ShiFeiBeng_SwitchMotorFault = shiFeiBeng_SwitchMotorFault;
    }
    public Boolean getZengYangJi_SwitchMotorFault() {
        return ZengYangJi_SwitchMotorFault;
    }
    public void setZengYangJi_SwitchMotorFault(Boolean zengYangJi_SwitchMotorFault) {
        ZengYangJi_SwitchMotorFault = zengYangJi_SwitchMotorFault;
    }
    public Boolean getReFengJi_SwitchMotorFault() {
        return ReFengJi_SwitchMotorFault;
    }
    public void setReFengJi_SwitchMotorFault(Boolean reFengJi_SwitchMotorFault) {
        ReFengJi_SwitchMotorFault = reFengJi_SwitchMotorFault;
    }
    public Boolean getZhaoMing1_SwitchMotorFault() {
        return ZhaoMing1_SwitchMotorFault;
    }
    public void setZhaoMing1_SwitchMotorFault(Boolean zhaoMing1_SwitchMotorFault) {
        ZhaoMing1_SwitchMotorFault = zhaoMing1_SwitchMotorFault;
    }
    public Boolean getZhaoMing2_SwitchMotorFault() {
        return ZhaoMing2_SwitchMotorFault;
    }
    public void setZhaoMing2_SwitchMotorFault(Boolean zhaoMing2_SwitchMotorFault) {
        ZhaoMing2_SwitchMotorFault = zhaoMing2_SwitchMotorFault;
    }
    public Boolean getLED_SwitchMotorFault() {
        return LED_SwitchMotorFault;
    }
    public void setLED_SwitchMotorFault(Boolean LED_SwitchMotorFault) {
        this.LED_SwitchMotorFault = LED_SwitchMotorFault;
    }
    public Boolean getDingTongFeng_MotorFault() {
        return DingTongFeng_MotorFault;
    }
    public void setDingTongFeng_MotorFault(Boolean dingTongFeng_MotorFault) {
        DingTongFeng_MotorFault = dingTongFeng_MotorFault;
    }
    public Boolean getWaiZheYang1_Forward_Feedback_Fault_Output() {
        return WaiZheYang1_Forward_Feedback_Fault_Output;
    }
    public void setWaiZheYang1_Forward_Feedback_Fault_Output(Boolean waiZheYang1_Forward_Feedback_Fault_Output) {
        WaiZheYang1_Forward_Feedback_Fault_Output = waiZheYang1_Forward_Feedback_Fault_Output;
    }
    public Boolean getWaiZheYang1_Reverse_Feedback_Fault_Output() {
        return WaiZheYang1_Reverse_Feedback_Fault_Output;
    }
    public void setWaiZheYang1_Reverse_Feedback_Fault_Output(Boolean waiZheYang1_Reverse_Feedback_Fault_Output) {
        WaiZheYang1_Reverse_Feedback_Fault_Output = waiZheYang1_Reverse_Feedback_Fault_Output;
    }
    public Boolean getWaiZheYang2_Forward_Feedback_Fault_Output() {
        return WaiZheYang2_Forward_Feedback_Fault_Output;
    }
    public void setWaiZheYang2_Forward_Feedback_Fault_Output(Boolean waiZheYang2_Forward_Feedback_Fault_Output) {
        WaiZheYang2_Forward_Feedback_Fault_Output = waiZheYang2_Forward_Feedback_Fault_Output;
    }
    public Boolean getWaiZheYang2_Reverse_Feedback_Fault_Output() {
        return WaiZheYang2_Reverse_Feedback_Fault_Output;
    }
    public void setWaiZheYang2_Reverse_Feedback_Fault_Output(Boolean waiZheYang2_Reverse_Feedback_Fault_Output) {
        WaiZheYang2_Reverse_Feedback_Fault_Output = waiZheYang2_Reverse_Feedback_Fault_Output;
    }
    public Boolean getNeiZheYang1_Forward_Feedback_Fault_Output() {
        return NeiZheYang1_Forward_Feedback_Fault_Output;
    }
    public void setNeiZheYang1_Forward_Feedback_Fault_Output(Boolean neiZheYang1_Forward_Feedback_Fault_Output) {
        NeiZheYang1_Forward_Feedback_Fault_Output = neiZheYang1_Forward_Feedback_Fault_Output;
    }
    public Boolean getNeiZheYang1_Reverse_Feedback_Fault_Output() {
        return NeiZheYang1_Reverse_Feedback_Fault_Output;
    }
    public void setNeiZheYang1_Reverse_Feedback_Fault_Output(Boolean neiZheYang1_Reverse_Feedback_Fault_Output) {
        NeiZheYang1_Reverse_Feedback_Fault_Output = neiZheYang1_Reverse_Feedback_Fault_Output;
    }
    public Boolean getNeiZheYang2_Forward_Feedback_Fault_Output() {
        return NeiZheYang2_Forward_Feedback_Fault_Output;
    }
    public void setNeiZheYang2_Forward_Feedback_Fault_Output(Boolean neiZheYang2_Forward_Feedback_Fault_Output) {
        NeiZheYang2_Forward_Feedback_Fault_Output = neiZheYang2_Forward_Feedback_Fault_Output;
    }
    public Boolean getNeiZheYang2_Reverse_Feedback_Fault_Output() {
        return NeiZheYang2_Reverse_Feedback_Fault_Output;
    }
    public void setNeiZheYang2_Reverse_Feedback_Fault_Output(Boolean neiZheYang2_Reverse_Feedback_Fault_Output) {
        NeiZheYang2_Reverse_Feedback_Fault_Output = neiZheYang2_Reverse_Feedback_Fault_Output;
    }
    public Boolean getFengJi1_Feedback_Fault_Output() {
        return FengJi1_Feedback_Fault_Output;
    }
    public void setFengJi1_Feedback_Fault_Output(Boolean fengJi1_Feedback_Fault_Output) {
        FengJi1_Feedback_Fault_Output = fengJi1_Feedback_Fault_Output;
    }
    public Boolean getFengJi2_Feedback_Fault_Output() {
        return FengJi2_Feedback_Fault_Output;
    }
    public void setFengJi2_Feedback_Fault_Output(Boolean fengJi2_Feedback_Fault_Output) {
        FengJi2_Feedback_Fault_Output = fengJi2_Feedback_Fault_Output;
    }
    public Boolean getFengJi3_Feedback_Fault_Output() {
        return FengJi3_Feedback_Fault_Output;
    }
    public void setFengJi3_Feedback_Fault_Output(Boolean fengJi3_Feedback_Fault_Output) {
        FengJi3_Feedback_Fault_Output = fengJi3_Feedback_Fault_Output;
    }
    public Boolean getGuanGaiShuiBeng_Feedback_Fault_Output() {
        return GuanGaiShuiBeng_Feedback_Fault_Output;
    }
    public void setGuanGaiShuiBeng_Feedback_Fault_Output(Boolean guanGaiShuiBeng_Feedback_Fault_Output) {
        GuanGaiShuiBeng_Feedback_Fault_Output = guanGaiShuiBeng_Feedback_Fault_Output;
    }
    public Boolean getShuiPeiShuiBeng_Feedback_Fault_Output() {
        return ShuiPeiShuiBeng_Feedback_Fault_Output;
    }
    public void setShuiPeiShuiBeng_Feedback_Fault_Output(Boolean shuiPeiShuiBeng_Feedback_Fault_Output) {
        ShuiPeiShuiBeng_Feedback_Fault_Output = shuiPeiShuiBeng_Feedback_Fault_Output;
    }
    public Boolean getShiFeiBeng_Feedback_Fault_Output() {
        return ShiFeiBeng_Feedback_Fault_Output;
    }
    public void setShiFeiBeng_Feedback_Fault_Output(Boolean shiFeiBeng_Feedback_Fault_Output) {
        ShiFeiBeng_Feedback_Fault_Output = shiFeiBeng_Feedback_Fault_Output;
    }
    public Boolean getZengYangJi_Feedback_Fault_Output() {
        return ZengYangJi_Feedback_Fault_Output;
    }
    public void setZengYangJi_Feedback_Fault_Output(Boolean zengYangJi_Feedback_Fault_Output) {
        ZengYangJi_Feedback_Fault_Output = zengYangJi_Feedback_Fault_Output;
    }
    public Boolean getReFengJi_Feedback_Fault_Output() {
        return ReFengJi_Feedback_Fault_Output;
    }
    public void setReFengJi_Feedback_Fault_Output(Boolean reFengJi_Feedback_Fault_Output) {
        ReFengJi_Feedback_Fault_Output = reFengJi_Feedback_Fault_Output;
    }
    public Boolean getZhaoMing1_Feedback_Fault_Output() {
        return ZhaoMing1_Feedback_Fault_Output;
    }
    public void setZhaoMing1_Feedback_Fault_Output(Boolean zhaoMing1_Feedback_Fault_Output) {
        ZhaoMing1_Feedback_Fault_Output = zhaoMing1_Feedback_Fault_Output;
    }
    public Boolean getZhaoMing2_Feedback_Fault_Output() {
        return ZhaoMing2_Feedback_Fault_Output;
    }
    public void setZhaoMing2_Feedback_Fault_Output(Boolean zhaoMing2_Feedback_Fault_Output) {
        ZhaoMing2_Feedback_Fault_Output = zhaoMing2_Feedback_Fault_Output;
    }
    public Boolean getLED_Feedback_Fault_Output() {
        return LED_Feedback_Fault_Output;
    }
    public void setLED_Feedback_Fault_Output(Boolean LED_Feedback_Fault_Output) {
        this.LED_Feedback_Fault_Output = LED_Feedback_Fault_Output;
    }
    public Boolean getDingTongFeng_Forward_Feedback_Fault_Output() {
        return DingTongFeng_Forward_Feedback_Fault_Output;
    }
    public void setDingTongFeng_Forward_Feedback_Fault_Output(Boolean dingTongFeng_Forward_Feedback_Fault_Output) {
        DingTongFeng_Forward_Feedback_Fault_Output = dingTongFeng_Forward_Feedback_Fault_Output;
    }
    public Boolean getDingTongFeng_Reverse_Feedback_Fault_Output() {
        return DingTongFeng_Reverse_Feedback_Fault_Output;
    }
    public void setDingTongFeng_Reverse_Feedback_Fault_Output(Boolean dingTongFeng_Reverse_Feedback_Fault_Output) {
        DingTongFeng_Reverse_Feedback_Fault_Output = dingTongFeng_Reverse_Feedback_Fault_Output;
    }
    public Boolean getFengMingQi() {
        return FengMingQi;
    }
    public void setFengMingQi(Boolean fengMingQi) {
        FengMingQi = fengMingQi;
    }
    public Boolean getRemote_Local_Control() {
        return Remote_Local_Control;
    }
    public void setRemote_Local_Control(Boolean remote_Local_Control) {
        Remote_Local_Control = remote_Local_Control;
    }
    public Boolean getShuiLian_SwitchMotorFault() {
        return ShuiLian_SwitchMotorFault;
    }
    public void setShuiLian_SwitchMotorFault(Boolean shuiLian_SwitchMotorFault) {
        ShuiLian_SwitchMotorFault = shuiLian_SwitchMotorFault;
    }
    public Boolean getShuiLian_Feedback_Fault_Output() {
        return ShuiLian_Feedback_Fault_Output;
    }
    public void setShuiLian_Feedback_Fault_Output(Boolean shuiLian_Feedback_Fault_Output) {
        ShuiLian_Feedback_Fault_Output = shuiLian_Feedback_Fault_Output;
    }
    public Boolean getEmergency_Stop_State() {
        return Emergency_Stop_State;
    }
    public void setEmergency_Stop_State(Boolean emergency_Stop_State) {
        Emergency_Stop_State = emergency_Stop_State;
    }
    public Boolean getWaiZheYang1_Forward_FeedBack() {
        return WaiZheYang1_Forward_FeedBack;
    }
    public void setWaiZheYang1_Forward_FeedBack(Boolean waiZheYang1_Forward_FeedBack) {
        WaiZheYang1_Forward_FeedBack = waiZheYang1_Forward_FeedBack;
    }
    public Boolean getWaiZheYang1_Reverse_FeedBack() {
        return WaiZheYang1_Reverse_FeedBack;
    }
    public void setWaiZheYang1_Reverse_FeedBack(Boolean waiZheYang1_Reverse_FeedBack) {
        WaiZheYang1_Reverse_FeedBack = waiZheYang1_Reverse_FeedBack;
    }
    public Boolean getWaiZheYang2_Forward_FeedBack() {
        return WaiZheYang2_Forward_FeedBack;
    }
    public void setWaiZheYang2_Forward_FeedBack(Boolean waiZheYang2_Forward_FeedBack) {
        WaiZheYang2_Forward_FeedBack = waiZheYang2_Forward_FeedBack;
    }
    public Boolean getWaiZheYang2_Reverse_FeedBack() {
        return WaiZheYang2_Reverse_FeedBack;
    }
    public void setWaiZheYang2_Reverse_FeedBack(Boolean waiZheYang2_Reverse_FeedBack) {
        WaiZheYang2_Reverse_FeedBack = waiZheYang2_Reverse_FeedBack;
    }
    public Boolean getNeiZheYang1_Forward_FeedBack() {
        return NeiZheYang1_Forward_FeedBack;
    }
    public void setNeiZheYang1_Forward_FeedBack(Boolean neiZheYang1_Forward_FeedBack) {
        NeiZheYang1_Forward_FeedBack = neiZheYang1_Forward_FeedBack;
    }
    public Boolean getNeiZheYang1_Reverse_FeedBack() {
        return NeiZheYang1_Reverse_FeedBack;
    }
    public void setNeiZheYang1_Reverse_FeedBack(Boolean neiZheYang1_Reverse_FeedBack) {
        NeiZheYang1_Reverse_FeedBack = neiZheYang1_Reverse_FeedBack;
    }
    public Boolean getNeiZheYang2_Forward_FeedBack() {
        return NeiZheYang2_Forward_FeedBack;
    }
    public void setNeiZheYang2_Forward_FeedBack(Boolean neiZheYang2_Forward_FeedBack) {
        NeiZheYang2_Forward_FeedBack = neiZheYang2_Forward_FeedBack;
    }
    public Boolean getNeiZheYang2_Reverse_FeedBack() {
        return NeiZheYang2_Reverse_FeedBack;
    }
    public void setNeiZheYang2_Reverse_FeedBack(Boolean neiZheYang2_Reverse_FeedBack) {
        NeiZheYang2_Reverse_FeedBack = neiZheYang2_Reverse_FeedBack;
    }
    public Boolean getFengJi1_FeedBack() {
        return FengJi1_FeedBack;
    }
    public void setFengJi1_FeedBack(Boolean fengJi1_FeedBack) {
        FengJi1_FeedBack = fengJi1_FeedBack;
    }
    public Boolean getFengJi2_FeedBack() {
        return FengJi2_FeedBack;
    }
    public void setFengJi2_FeedBack(Boolean fengJi2_FeedBack) {
        FengJi2_FeedBack = fengJi2_FeedBack;
    }
    public Boolean getFengJi3_FeedBack() {
        return FengJi3_FeedBack;
    }
    public void setFengJi3_FeedBack(Boolean fengJi3_FeedBack) {
        FengJi3_FeedBack = fengJi3_FeedBack;
    }
    public Boolean getGuanGaiShuiBeng_FeedBack() {
        return GuanGaiShuiBeng_FeedBack;
    }
    public void setGuanGaiShuiBeng_FeedBack(Boolean guanGaiShuiBeng_FeedBack) {
        GuanGaiShuiBeng_FeedBack = guanGaiShuiBeng_FeedBack;
    }
    public Boolean getShuiPeiShuiBeng_FeedBack() {
        return ShuiPeiShuiBeng_FeedBack;
    }
    public void setShuiPeiShuiBeng_FeedBack(Boolean shuiPeiShuiBeng_FeedBack) {
        ShuiPeiShuiBeng_FeedBack = shuiPeiShuiBeng_FeedBack;
    }
    public Boolean getShiFeiBeng_FeedBack() {
        return ShiFeiBeng_FeedBack;
    }
    public void setShiFeiBeng_FeedBack(Boolean shiFeiBeng_FeedBack) {
        ShiFeiBeng_FeedBack = shiFeiBeng_FeedBack;
    }
    public Boolean getZengYangJi_FeedBack() {
        return ZengYangJi_FeedBack;
    }
    public void setZengYangJi_FeedBack(Boolean zengYangJi_FeedBack) {
        ZengYangJi_FeedBack = zengYangJi_FeedBack;
    }
    public Boolean getReFengJi_FeedBack() {
        return ReFengJi_FeedBack;
    }
    public void setReFengJi_FeedBack(Boolean reFengJi_FeedBack) {
        ReFengJi_FeedBack = reFengJi_FeedBack;
    }
    public Boolean getZhaoMing1_FeedBack() {
        return ZhaoMing1_FeedBack;
    }
    public void setZhaoMing1_FeedBack(Boolean zhaoMing1_FeedBack) {
        ZhaoMing1_FeedBack = zhaoMing1_FeedBack;
    }
    public Boolean getZhaoMing2_FeedBack() {
        return ZhaoMing2_FeedBack;
    }
    public void setZhaoMing2_FeedBack(Boolean zhaoMing2_FeedBack) {
        ZhaoMing2_FeedBack = zhaoMing2_FeedBack;
    }
    public Boolean getLED_FeedBack() {
        return LED_FeedBack;
    }
    public void setLED_FeedBack(Boolean LED_FeedBack) {
        this.LED_FeedBack = LED_FeedBack;
    }
    public Boolean getDingTongFeng_Forward_FeedBack() {
        return DingTongFeng_Forward_FeedBack;
    }
    public void setDingTongFeng_Forward_FeedBack(Boolean dingTongFeng_Forward_FeedBack) {
        DingTongFeng_Forward_FeedBack = dingTongFeng_Forward_FeedBack;
    }
    public Boolean getDingTongFeng_Reverse_FeedBack() {
        return DingTongFeng_Reverse_FeedBack;
    }
    public void setDingTongFeng_Reverse_FeedBack(Boolean dingTongFeng_Reverse_FeedBack) {
        DingTongFeng_Reverse_FeedBack = dingTongFeng_Reverse_FeedBack;
    }
    public Boolean getShuiLianBuShui_ElectromagneticValveOutput() {
        return ShuiLianBuShui_ElectromagneticValveOutput;
    }
    public void setShuiLianBuShui_ElectromagneticValveOutput(Boolean shuiLianBuShui_ElectromagneticValveOutput) {
        ShuiLianBuShui_ElectromagneticValveOutput = shuiLianBuShui_ElectromagneticValveOutput;
    }
    public Boolean getShuiChiBuShui_ElectromagneticValveOutput() {
        return ShuiChiBuShui_ElectromagneticValveOutput;
    }
    public void setShuiChiBuShui_ElectromagneticValveOutput(Boolean shuiChiBuShui_ElectromagneticValveOutput) {
        ShuiChiBuShui_ElectromagneticValveOutput = shuiChiBuShui_ElectromagneticValveOutput;
    }
    public Boolean getMiaoChuangGuanGai1_ElectromagneticValveOutput() {
        return MiaoChuangGuanGai1_ElectromagneticValveOutput;
    }
    public void setMiaoChuangGuanGai1_ElectromagneticValveOutput(Boolean miaoChuangGuanGai1_ElectromagneticValveOutput) {
        MiaoChuangGuanGai1_ElectromagneticValveOutput = miaoChuangGuanGai1_ElectromagneticValveOutput;
    }
    public Boolean getMiaoChuangGuanGai2_ElectromagneticValveOutput() {
        return MiaoChuangGuanGai2_ElectromagneticValveOutput;
    }
    public void setMiaoChuangGuanGai2_ElectromagneticValveOutput(Boolean miaoChuangGuanGai2_ElectromagneticValveOutput) {
        MiaoChuangGuanGai2_ElectromagneticValveOutput = miaoChuangGuanGai2_ElectromagneticValveOutput;
    }
    public Boolean getMiaoChuangGuanGai3_ElectromagneticValveOutput() {
        return MiaoChuangGuanGai3_ElectromagneticValveOutput;
    }
    public void setMiaoChuangGuanGai3_ElectromagneticValveOutput(Boolean miaoChuangGuanGai3_ElectromagneticValveOutput) {
        MiaoChuangGuanGai3_ElectromagneticValveOutput = miaoChuangGuanGai3_ElectromagneticValveOutput;
    }
    public Boolean getMiaoChuangGuanGai4_ElectromagneticValveOutput() {
        return MiaoChuangGuanGai4_ElectromagneticValveOutput;
    }
    public void setMiaoChuangGuanGai4_ElectromagneticValveOutput(Boolean miaoChuangGuanGai4_ElectromagneticValveOutput) {
        MiaoChuangGuanGai4_ElectromagneticValveOutput = miaoChuangGuanGai4_ElectromagneticValveOutput;
    }
    public Boolean getMiaoChuangGuanGai5_ElectromagneticValveOutput() {
        return MiaoChuangGuanGai5_ElectromagneticValveOutput;
    }
    public void setMiaoChuangGuanGai5_ElectromagneticValveOutput(Boolean miaoChuangGuanGai5_ElectromagneticValveOutput) {
        MiaoChuangGuanGai5_ElectromagneticValveOutput = miaoChuangGuanGai5_ElectromagneticValveOutput;
    }
    public Boolean getMiaoChuangGuanGai6_ElectromagneticValveOutput() {
        return MiaoChuangGuanGai6_ElectromagneticValveOutput;
    }
    public void setMiaoChuangGuanGai6_ElectromagneticValveOutput(Boolean miaoChuangGuanGai6_ElectromagneticValveOutput) {
        MiaoChuangGuanGai6_ElectromagneticValveOutput = miaoChuangGuanGai6_ElectromagneticValveOutput;
    }
    public Boolean getMiaoChuangGuanGai7_ElectromagneticValveOutput() {
        return MiaoChuangGuanGai7_ElectromagneticValveOutput;
    }
    public void setMiaoChuangGuanGai7_ElectromagneticValveOutput(Boolean miaoChuangGuanGai7_ElectromagneticValveOutput) {
        MiaoChuangGuanGai7_ElectromagneticValveOutput = miaoChuangGuanGai7_ElectromagneticValveOutput;
    }
    public Boolean getMiaoChuangGuanGai8_ElectromagneticValveOutput() {
        return MiaoChuangGuanGai8_ElectromagneticValveOutput;
    }
    public void setMiaoChuangGuanGai8_ElectromagneticValveOutput(Boolean miaoChuangGuanGai8_ElectromagneticValveOutput) {
        MiaoChuangGuanGai8_ElectromagneticValveOutput = miaoChuangGuanGai8_ElectromagneticValveOutput;
    }
    public Boolean getMiaoChuangGuanGai9_ElectromagneticValveOutput() {
        return MiaoChuangGuanGai9_ElectromagneticValveOutput;
    }
    public void setMiaoChuangGuanGai9_ElectromagneticValveOutput(Boolean miaoChuangGuanGai9_ElectromagneticValveOutput) {
        MiaoChuangGuanGai9_ElectromagneticValveOutput = miaoChuangGuanGai9_ElectromagneticValveOutput;
    }
    public Boolean getMiaoChuangGuanGai10_ElectromagneticValveOutput() {
        return MiaoChuangGuanGai10_ElectromagneticValveOutput;
    }
    public void setMiaoChuangGuanGai10_ElectromagneticValveOutput(Boolean miaoChuangGuanGai10_ElectromagneticValveOutput) {
        MiaoChuangGuanGai10_ElectromagneticValveOutput = miaoChuangGuanGai10_ElectromagneticValveOutput;
    }
    public Boolean getMiaoChuangGuanGai11_ElectromagneticValveOutput() {
        return MiaoChuangGuanGai11_ElectromagneticValveOutput;
    }
    public void setMiaoChuangGuanGai11_ElectromagneticValveOutput(Boolean miaoChuangGuanGai11_ElectromagneticValveOutput) {
        MiaoChuangGuanGai11_ElectromagneticValveOutput = miaoChuangGuanGai11_ElectromagneticValveOutput;
    }
    public Boolean getMiaoChuangGuanGai12_ElectromagneticValveOutput() {
        return MiaoChuangGuanGai12_ElectromagneticValveOutput;
    }
    public void setMiaoChuangGuanGai12_ElectromagneticValveOutput(Boolean miaoChuangGuanGai12_ElectromagneticValveOutput) {
        MiaoChuangGuanGai12_ElectromagneticValveOutput = miaoChuangGuanGai12_ElectromagneticValveOutput;
    }
    public Boolean getMiaoChuangGuanGai13_ElectromagneticValveOutput() {
        return MiaoChuangGuanGai13_ElectromagneticValveOutput;
    }
    public void setMiaoChuangGuanGai13_ElectromagneticValveOutput(Boolean miaoChuangGuanGai13_ElectromagneticValveOutput) {
        MiaoChuangGuanGai13_ElectromagneticValveOutput = miaoChuangGuanGai13_ElectromagneticValveOutput;
    }
    public Boolean getMiaoChuangGuanGai14_ElectromagneticValveOutput() {
        return MiaoChuangGuanGai14_ElectromagneticValveOutput;
    }
    public void setMiaoChuangGuanGai14_ElectromagneticValveOutput(Boolean miaoChuangGuanGai14_ElectromagneticValveOutput) {
        MiaoChuangGuanGai14_ElectromagneticValveOutput = miaoChuangGuanGai14_ElectromagneticValveOutput;
    }
    public Boolean getMiaoChuangGuanGai15_ElectromagneticValveOutput() {
        return MiaoChuangGuanGai15_ElectromagneticValveOutput;
    }
    public void setMiaoChuangGuanGai15_ElectromagneticValveOutput(Boolean miaoChuangGuanGai15_ElectromagneticValveOutput) {
        MiaoChuangGuanGai15_ElectromagneticValveOutput = miaoChuangGuanGai15_ElectromagneticValveOutput;
    }
    public Boolean getMiaoChuangGuanGai16_ElectromagneticValveOutput() {
        return MiaoChuangGuanGai16_ElectromagneticValveOutput;
    }
    public void setMiaoChuangGuanGai16_ElectromagneticValveOutput(Boolean miaoChuangGuanGai16_ElectromagneticValveOutput) {
        MiaoChuangGuanGai16_ElectromagneticValveOutput = miaoChuangGuanGai16_ElectromagneticValveOutput;
    }
    public Boolean getMiaoChuangGuanGai17_ElectromagneticValveOutput() {
        return MiaoChuangGuanGai17_ElectromagneticValveOutput;
    }
    public void setMiaoChuangGuanGai17_ElectromagneticValveOutput(Boolean miaoChuangGuanGai17_ElectromagneticValveOutput) {
        MiaoChuangGuanGai17_ElectromagneticValveOutput = miaoChuangGuanGai17_ElectromagneticValveOutput;
    }
    public Boolean getMiaoChuangGuanGai18_ElectromagneticValveOutput() {
        return MiaoChuangGuanGai18_ElectromagneticValveOutput;
    }
    public void setMiaoChuangGuanGai18_ElectromagneticValveOutput(Boolean miaoChuangGuanGai18_ElectromagneticValveOutput) {
        MiaoChuangGuanGai18_ElectromagneticValveOutput = miaoChuangGuanGai18_ElectromagneticValveOutput;
    }
    public Boolean getMiaoChuangGuanGai19_ElectromagneticValveOutput() {
        return MiaoChuangGuanGai19_ElectromagneticValveOutput;
    }
    public void setMiaoChuangGuanGai19_ElectromagneticValveOutput(Boolean miaoChuangGuanGai19_ElectromagneticValveOutput) {
        MiaoChuangGuanGai19_ElectromagneticValveOutput = miaoChuangGuanGai19_ElectromagneticValveOutput;
    }
    public Boolean getMiaoChuangGuanGai20_ElectromagneticValveOutput() {
        return MiaoChuangGuanGai20_ElectromagneticValveOutput;
    }
    public void setMiaoChuangGuanGai20_ElectromagneticValveOutput(Boolean miaoChuangGuanGai20_ElectromagneticValveOutput) {
        MiaoChuangGuanGai20_ElectromagneticValveOutput = miaoChuangGuanGai20_ElectromagneticValveOutput;
    }
    public Boolean getMiaoChuangGuanGai21_ElectromagneticValveOutput() {
        return MiaoChuangGuanGai21_ElectromagneticValveOutput;
    }
    public void setMiaoChuangGuanGai21_ElectromagneticValveOutput(Boolean miaoChuangGuanGai21_ElectromagneticValveOutput) {
        MiaoChuangGuanGai21_ElectromagneticValveOutput = miaoChuangGuanGai21_ElectromagneticValveOutput;
    }
    public Boolean getMiaoChuangGuanGai22_ElectromagneticValveOutput() {
        return MiaoChuangGuanGai22_ElectromagneticValveOutput;
    }
    public void setMiaoChuangGuanGai22_ElectromagneticValveOutput(Boolean miaoChuangGuanGai22_ElectromagneticValveOutput) {
        MiaoChuangGuanGai22_ElectromagneticValveOutput = miaoChuangGuanGai22_ElectromagneticValveOutput;
    }
    public Boolean getMiaoChuangGuanGai23_ElectromagneticValveOutput() {
        return MiaoChuangGuanGai23_ElectromagneticValveOutput;
    }
    public void setMiaoChuangGuanGai23_ElectromagneticValveOutput(Boolean miaoChuangGuanGai23_ElectromagneticValveOutput) {
        MiaoChuangGuanGai23_ElectromagneticValveOutput = miaoChuangGuanGai23_ElectromagneticValveOutput;
    }
    public Boolean getMiaoChuangGuanGai24_ElectromagneticValveOutput() {
        return MiaoChuangGuanGai24_ElectromagneticValveOutput;
    }
    public void setMiaoChuangGuanGai24_ElectromagneticValveOutput(Boolean miaoChuangGuanGai24_ElectromagneticValveOutput) {
        MiaoChuangGuanGai24_ElectromagneticValveOutput = miaoChuangGuanGai24_ElectromagneticValveOutput;
    }
    public Boolean getMiaoChuangGuanGai25_ElectromagneticValveOutput() {
        return MiaoChuangGuanGai25_ElectromagneticValveOutput;
    }
    public void setMiaoChuangGuanGai25_ElectromagneticValveOutput(Boolean miaoChuangGuanGai25_ElectromagneticValveOutput) {
        MiaoChuangGuanGai25_ElectromagneticValveOutput = miaoChuangGuanGai25_ElectromagneticValveOutput;
    }
    public Boolean getMiaoChuangGuanGai26_ElectromagneticValveOutput() {
        return MiaoChuangGuanGai26_ElectromagneticValveOutput;
    }
    public void setMiaoChuangGuanGai26_ElectromagneticValveOutput(Boolean miaoChuangGuanGai26_ElectromagneticValveOutput) {
        MiaoChuangGuanGai26_ElectromagneticValveOutput = miaoChuangGuanGai26_ElectromagneticValveOutput;
    }
    public Boolean getMiaoChuangGuanGai27_ElectromagneticValveOutput() {
        return MiaoChuangGuanGai27_ElectromagneticValveOutput;
    }
    public void setMiaoChuangGuanGai27_ElectromagneticValveOutput(Boolean miaoChuangGuanGai27_ElectromagneticValveOutput) {
        MiaoChuangGuanGai27_ElectromagneticValveOutput = miaoChuangGuanGai27_ElectromagneticValveOutput;
    }
    public Boolean getMiaoChuangGuanGai28_ElectromagneticValveOutput() {
        return MiaoChuangGuanGai28_ElectromagneticValveOutput;
    }
    public void setMiaoChuangGuanGai28_ElectromagneticValveOutput(Boolean miaoChuangGuanGai28_ElectromagneticValveOutput) {
        MiaoChuangGuanGai28_ElectromagneticValveOutput = miaoChuangGuanGai28_ElectromagneticValveOutput;
    }
    public Boolean getMiaoChuangGuanGai29_ElectromagneticValveOutput() {
        return MiaoChuangGuanGai29_ElectromagneticValveOutput;
    }
    public void setMiaoChuangGuanGai29_ElectromagneticValveOutput(Boolean miaoChuangGuanGai29_ElectromagneticValveOutput) {
        MiaoChuangGuanGai29_ElectromagneticValveOutput = miaoChuangGuanGai29_ElectromagneticValveOutput;
    }
    public Boolean getMiaoChuangGuanGai30_ElectromagneticValveOutput() {
        return MiaoChuangGuanGai30_ElectromagneticValveOutput;
    }
    public void setMiaoChuangGuanGai30_ElectromagneticValveOutput(Boolean miaoChuangGuanGai30_ElectromagneticValveOutput) {
        MiaoChuangGuanGai30_ElectromagneticValveOutput = miaoChuangGuanGai30_ElectromagneticValveOutput;
    }
    public Boolean getMiaoChuangGuanGai31_ElectromagneticValveOutput() {
        return MiaoChuangGuanGai31_ElectromagneticValveOutput;
    }
    public void setMiaoChuangGuanGai31_ElectromagneticValveOutput(Boolean miaoChuangGuanGai31_ElectromagneticValveOutput) {
        MiaoChuangGuanGai31_ElectromagneticValveOutput = miaoChuangGuanGai31_ElectromagneticValveOutput;
    }
    public Boolean getMiaoChuangGuanGai32_ElectromagneticValveOutput() {
        return MiaoChuangGuanGai32_ElectromagneticValveOutput;
    }
    public void setMiaoChuangGuanGai32_ElectromagneticValveOutput(Boolean miaoChuangGuanGai32_ElectromagneticValveOutput) {
        MiaoChuangGuanGai32_ElectromagneticValveOutput = miaoChuangGuanGai32_ElectromagneticValveOutput;
    }
    public Boolean getMiaoChuangGuanGai33_ElectromagneticValveOutput() {
        return MiaoChuangGuanGai33_ElectromagneticValveOutput;
    }
    public void setMiaoChuangGuanGai33_ElectromagneticValveOutput(Boolean miaoChuangGuanGai33_ElectromagneticValveOutput) {
        MiaoChuangGuanGai33_ElectromagneticValveOutput = miaoChuangGuanGai33_ElectromagneticValveOutput;
    }
    public Boolean getMiaoChuangGuanGai34_ElectromagneticValveOutput() {
        return MiaoChuangGuanGai34_ElectromagneticValveOutput;
    }
    public void setMiaoChuangGuanGai34_ElectromagneticValveOutput(Boolean miaoChuangGuanGai34_ElectromagneticValveOutput) {
        MiaoChuangGuanGai34_ElectromagneticValveOutput = miaoChuangGuanGai34_ElectromagneticValveOutput;
    }
    public Boolean getMiaoChuangGuanGai35_ElectromagneticValveOutput() {
        return MiaoChuangGuanGai35_ElectromagneticValveOutput;
    }
    public void setMiaoChuangGuanGai35_ElectromagneticValveOutput(Boolean miaoChuangGuanGai35_ElectromagneticValveOutput) {
        MiaoChuangGuanGai35_ElectromagneticValveOutput = miaoChuangGuanGai35_ElectromagneticValveOutput;
    }
    public Boolean getMiaoChuangGuanGai36_ElectromagneticValveOutput() {
        return MiaoChuangGuanGai36_ElectromagneticValveOutput;
    }
    public void setMiaoChuangGuanGai36_ElectromagneticValveOutput(Boolean miaoChuangGuanGai36_ElectromagneticValveOutput) {
        MiaoChuangGuanGai36_ElectromagneticValveOutput = miaoChuangGuanGai36_ElectromagneticValveOutput;
    }
    public Boolean getMiaoChuangGuanGai37_ElectromagneticValveOutput() {
        return MiaoChuangGuanGai37_ElectromagneticValveOutput;
    }
    public void setMiaoChuangGuanGai37_ElectromagneticValveOutput(Boolean miaoChuangGuanGai37_ElectromagneticValveOutput) {
        MiaoChuangGuanGai37_ElectromagneticValveOutput = miaoChuangGuanGai37_ElectromagneticValveOutput;
    }
    public Boolean getMiaoChuangGuanGai38_ElectromagneticValveOutput() {
        return MiaoChuangGuanGai38_ElectromagneticValveOutput;
    }
    public void setMiaoChuangGuanGai38_ElectromagneticValveOutput(Boolean miaoChuangGuanGai38_ElectromagneticValveOutput) {
        MiaoChuangGuanGai38_ElectromagneticValveOutput = miaoChuangGuanGai38_ElectromagneticValveOutput;
    }
    public Boolean getMiaoChuangGuanGai39_ElectromagneticValveOutput() {
        return MiaoChuangGuanGai39_ElectromagneticValveOutput;
    }
    public void setMiaoChuangGuanGai39_ElectromagneticValveOutput(Boolean miaoChuangGuanGai39_ElectromagneticValveOutput) {
        MiaoChuangGuanGai39_ElectromagneticValveOutput = miaoChuangGuanGai39_ElectromagneticValveOutput;
    }
    public Boolean getMiaoChuangGuanGai40_ElectromagneticValveOutput() {
        return MiaoChuangGuanGai40_ElectromagneticValveOutput;
    }
    public void setMiaoChuangGuanGai40_ElectromagneticValveOutput(Boolean miaoChuangGuanGai40_ElectromagneticValveOutput) {
        MiaoChuangGuanGai40_ElectromagneticValveOutput = miaoChuangGuanGai40_ElectromagneticValveOutput;
    }
    public Boolean getMiaoChuangGuanGai41_ElectromagneticValveOutput() {
        return MiaoChuangGuanGai41_ElectromagneticValveOutput;
    }
    public void setMiaoChuangGuanGai41_ElectromagneticValveOutput(Boolean miaoChuangGuanGai41_ElectromagneticValveOutput) {
        MiaoChuangGuanGai41_ElectromagneticValveOutput = miaoChuangGuanGai41_ElectromagneticValveOutput;
    }
    public Boolean getMiaoChuangGuanGai42_ElectromagneticValveOutput() {
        return MiaoChuangGuanGai42_ElectromagneticValveOutput;
    }
    public void setMiaoChuangGuanGai42_ElectromagneticValveOutput(Boolean miaoChuangGuanGai42_ElectromagneticValveOutput) {
        MiaoChuangGuanGai42_ElectromagneticValveOutput = miaoChuangGuanGai42_ElectromagneticValveOutput;
    }
    public Boolean getMiaoChuangGuanGai43_ElectromagneticValveOutput() {
        return MiaoChuangGuanGai43_ElectromagneticValveOutput;
    }
    public void setMiaoChuangGuanGai43_ElectromagneticValveOutput(Boolean miaoChuangGuanGai43_ElectromagneticValveOutput) {
        MiaoChuangGuanGai43_ElectromagneticValveOutput = miaoChuangGuanGai43_ElectromagneticValveOutput;
    }
    public Boolean getMiaoChuangGuanGai44_ElectromagneticValveOutput() {
        return MiaoChuangGuanGai44_ElectromagneticValveOutput;
    }
    public void setMiaoChuangGuanGai44_ElectromagneticValveOutput(Boolean miaoChuangGuanGai44_ElectromagneticValveOutput) {
        MiaoChuangGuanGai44_ElectromagneticValveOutput = miaoChuangGuanGai44_ElectromagneticValveOutput;
    }
    public Boolean getMiaoChuangGuanGai45_ElectromagneticValveOutput() {
        return MiaoChuangGuanGai45_ElectromagneticValveOutput;
    }
    public void setMiaoChuangGuanGai45_ElectromagneticValveOutput(Boolean miaoChuangGuanGai45_ElectromagneticValveOutput) {
        MiaoChuangGuanGai45_ElectromagneticValveOutput = miaoChuangGuanGai45_ElectromagneticValveOutput;
    }
    public Boolean getMiaoChuangGuanGai46_ElectromagneticValveOutput() {
        return MiaoChuangGuanGai46_ElectromagneticValveOutput;
    }
    public void setMiaoChuangGuanGai46_ElectromagneticValveOutput(Boolean miaoChuangGuanGai46_ElectromagneticValveOutput) {
        MiaoChuangGuanGai46_ElectromagneticValveOutput = miaoChuangGuanGai46_ElectromagneticValveOutput;
    }
    public Boolean getMiaoChuangGuanGai47_ElectromagneticValveOutput() {
        return MiaoChuangGuanGai47_ElectromagneticValveOutput;
    }
    public void setMiaoChuangGuanGai47_ElectromagneticValveOutput(Boolean miaoChuangGuanGai47_ElectromagneticValveOutput) {
        MiaoChuangGuanGai47_ElectromagneticValveOutput = miaoChuangGuanGai47_ElectromagneticValveOutput;
    }
    public Boolean getMiaoChuangGuanGai48_ElectromagneticValveOutput() {
        return MiaoChuangGuanGai48_ElectromagneticValveOutput;
    }
    public void setMiaoChuangGuanGai48_ElectromagneticValveOutput(Boolean miaoChuangGuanGai48_ElectromagneticValveOutput) {
        MiaoChuangGuanGai48_ElectromagneticValveOutput = miaoChuangGuanGai48_ElectromagneticValveOutput;
    }
    public Boolean getMiaoChuangGuanGai49_ElectromagneticValveOutput() {
        return MiaoChuangGuanGai49_ElectromagneticValveOutput;
    }
    public void setMiaoChuangGuanGai49_ElectromagneticValveOutput(Boolean miaoChuangGuanGai49_ElectromagneticValveOutput) {
        MiaoChuangGuanGai49_ElectromagneticValveOutput = miaoChuangGuanGai49_ElectromagneticValveOutput;
    }
    public Boolean getMiaoChuangGuanGai50_ElectromagneticValveOutput() {
        return MiaoChuangGuanGai50_ElectromagneticValveOutput;
    }
    public void setMiaoChuangGuanGai50_ElectromagneticValveOutput(Boolean miaoChuangGuanGai50_ElectromagneticValveOutput) {
        MiaoChuangGuanGai50_ElectromagneticValveOutput = miaoChuangGuanGai50_ElectromagneticValveOutput;
    }
    public Boolean getMiaoChuangGuanGai51_ElectromagneticValveOutput() {
        return MiaoChuangGuanGai51_ElectromagneticValveOutput;
    }
    public void setMiaoChuangGuanGai51_ElectromagneticValveOutput(Boolean miaoChuangGuanGai51_ElectromagneticValveOutput) {
        MiaoChuangGuanGai51_ElectromagneticValveOutput = miaoChuangGuanGai51_ElectromagneticValveOutput;
    }
    public Boolean getMiaoChuangGuanGai52_ElectromagneticValveOutput() {
        return MiaoChuangGuanGai52_ElectromagneticValveOutput;
    }
    public void setMiaoChuangGuanGai52_ElectromagneticValveOutput(Boolean miaoChuangGuanGai52_ElectromagneticValveOutput) {
        MiaoChuangGuanGai52_ElectromagneticValveOutput = miaoChuangGuanGai52_ElectromagneticValveOutput;
    }
    public Boolean getMiaoChuangGuanGai53_ElectromagneticValveOutput() {
        return MiaoChuangGuanGai53_ElectromagneticValveOutput;
    }
    public void setMiaoChuangGuanGai53_ElectromagneticValveOutput(Boolean miaoChuangGuanGai53_ElectromagneticValveOutput) {
        MiaoChuangGuanGai53_ElectromagneticValveOutput = miaoChuangGuanGai53_ElectromagneticValveOutput;
    }
    public Boolean getMiaoChuangGuanGai54_ElectromagneticValveOutput() {
        return MiaoChuangGuanGai54_ElectromagneticValveOutput;
    }
    public void setMiaoChuangGuanGai54_ElectromagneticValveOutput(Boolean miaoChuangGuanGai54_ElectromagneticValveOutput) {
        MiaoChuangGuanGai54_ElectromagneticValveOutput = miaoChuangGuanGai54_ElectromagneticValveOutput;
    }
    public Boolean getMiaoChuangGuanGai55_ElectromagneticValveOutput() {
        return MiaoChuangGuanGai55_ElectromagneticValveOutput;
    }
    public void setMiaoChuangGuanGai55_ElectromagneticValveOutput(Boolean miaoChuangGuanGai55_ElectromagneticValveOutput) {
        MiaoChuangGuanGai55_ElectromagneticValveOutput = miaoChuangGuanGai55_ElectromagneticValveOutput;
    }
    public Boolean getMiaoChuangGuanGai56_ElectromagneticValveOutput() {
        return MiaoChuangGuanGai56_ElectromagneticValveOutput;
    }
    public void setMiaoChuangGuanGai56_ElectromagneticValveOutput(Boolean miaoChuangGuanGai56_ElectromagneticValveOutput) {
        MiaoChuangGuanGai56_ElectromagneticValveOutput = miaoChuangGuanGai56_ElectromagneticValveOutput;
    }
    public Boolean getMiaoChuangGuanGai57_ElectromagneticValveOutput() {
        return MiaoChuangGuanGai57_ElectromagneticValveOutput;
    }
    public void setMiaoChuangGuanGai57_ElectromagneticValveOutput(Boolean miaoChuangGuanGai57_ElectromagneticValveOutput) {
        MiaoChuangGuanGai57_ElectromagneticValveOutput = miaoChuangGuanGai57_ElectromagneticValveOutput;
    }
    public Boolean getMiaoChuangGuanGai58_ElectromagneticValveOutput() {
        return MiaoChuangGuanGai58_ElectromagneticValveOutput;
    }
    public void setMiaoChuangGuanGai58_ElectromagneticValveOutput(Boolean miaoChuangGuanGai58_ElectromagneticValveOutput) {
        MiaoChuangGuanGai58_ElectromagneticValveOutput = miaoChuangGuanGai58_ElectromagneticValveOutput;
    }
    public Boolean getMiaoChuangGuanGai59_ElectromagneticValveOutput() {
        return MiaoChuangGuanGai59_ElectromagneticValveOutput;
    }
    public void setMiaoChuangGuanGai59_ElectromagneticValveOutput(Boolean miaoChuangGuanGai59_ElectromagneticValveOutput) {
        MiaoChuangGuanGai59_ElectromagneticValveOutput = miaoChuangGuanGai59_ElectromagneticValveOutput;
    }
    public Boolean getMiaoChuangGuanGai60_ElectromagneticValveOutput() {
        return MiaoChuangGuanGai60_ElectromagneticValveOutput;
    }
    public void setMiaoChuangGuanGai60_ElectromagneticValveOutput(Boolean miaoChuangGuanGai60_ElectromagneticValveOutput) {
        MiaoChuangGuanGai60_ElectromagneticValveOutput = miaoChuangGuanGai60_ElectromagneticValveOutput;
    }
    public Boolean getShuiLian_FeedBack() {
        return ShuiLian_FeedBack;
    }
    public void setShuiLian_FeedBack(Boolean shuiLian_FeedBack) {
        ShuiLian_FeedBack = shuiLian_FeedBack;
    }
}
