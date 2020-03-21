package com.farm.service;
/**
 * @Author: Rain
 * @Description: 整个数据帧的长度第三位的16进制数转换为10进制加三乘2
 * 这里定义解析各种从基站传过来的数据的方法，换句话说，只要是基站/DTU发过来的消息都从这里解析
 * @Date: Created on 2018/11/1  15:52
 */
public interface DataParsingService {
    /**
     * 解析从LORA网关发送的16进制字符串
     * 这里是一个总的入口
     * @param hexData
     */
    void parseDataFromGateway(String hexData);
    /**
     * 解析DTU发送的故障和反馈状态信息
     * @param hexData
     */
    void parseErrorDataFromDtu(String hexData);
    /**
     * 解析DTU发送的气象站传感器信息
     * @param hexData
     */
    void parseWeatherDataFromDTU(String hexData);
    /**
     * 解析0X01心跳数据
     * @param hexData
     */
    void parseHeartbeatInfo(String hexData);
    /**
     * 解析0X03请求授时数据
     * @param hexData
     */
    void parseTimeRequestInfo(String hexData);
    /**
     * 解析0X05基站登陆数据
     * fffe240a05864867027996476f030111071b0f20018b8402c73be964b5b3fea873206dda16ccaf
     * @param hexData
     */
    String parseLoginInfo(String hexData);
    /**
     * 解析主信令为0x07的类型的基站提交数据。
     * @param hexData
     */
    void parseSubmitInfo(String hexData);
    /**
     * 解析0X09基站报警数据
     * @param hexData
     */
    void parseAlarmInfo(String hexData);
    /**
     * 解析0X0C平台控制应答数据
     * @param hexData
     */
    void parseResponseInfoForControl(String hexData);
    /**
     * 解析0X0E类型基站对平台查询指令的应答
     * @param hexData
     */
    void parseResponseInfoForRetrieve(String hexData);
}
