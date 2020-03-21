package com.farm.service.serviceImpl;
import com.farm.cache.ChannelCache;
import com.farm.dao.PacketDao;
import com.farm.entity.ErrorAndStatus;
import com.farm.entity.data.Packet;
import com.farm.entity.data.WeatherPacket;
import com.farm.service.DataHandlingService;
import com.farm.service.DataParsingService;
import com.farm.service.ModbusService;
import com.farm.utils.*;
import io.netty.channel.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;
/**
 * @Author: Rain
 * @Description:
 * @Date: Created on 2018/11/1 15:52
 */
@Service
@Slf4j
@SuppressWarnings("noinspection SpellCheckingInspection")
public class DataParsingServiceImpl implements DataParsingService {
    private Channel channel = null;
    @Autowired
    private PacketDao packetDao;
    public PacketDao getPacketDao() {
        return packetDao;
    }
    @Autowired
    private DataHandlingService handlingService;
    public DataHandlingService getHandlingService() {
        return handlingService;
    }
    @Autowired
    private ModbusService modbusService;
    /**
     * 解决autowired 注入为空的问题
     */
    private static DataParsingServiceImpl dataParsingServiceImpl;
    @PostConstruct
    public void init() {
        dataParsingServiceImpl = this;
        dataParsingServiceImpl.packetDao = this.packetDao;
        dataParsingServiceImpl.handlingService = this.handlingService;
    }
    @Override
    public void parseDataFromGateway(String hexData) {
        if (channel==null) {
            channel = ChannelCache.getChannelByName("01");
        }
        String dataType = ParseUtil.getDataType(hexData);
        switch (dataType) {
            case "01":
                parseHeartbeatInfo(hexData);
                break;
            case "03":
                parseTimeRequestInfo(hexData);
                break;
            case "05":
                log.info("login info");
                //parseLoginInfo(hexData);
                break;
            case "07":
                parseSubmitInfo(hexData);
                break;
            default:
                break;
        }
    }
    @Override
    public void parseErrorDataFromDtu(String hexData) {
        ErrorAndStatus status = ParseUpStreamInfoUtil.parseErrorAndFeedbackStatusData(hexData);
        handlingService.storeAndPushErrorStatusData(status);
    }
    @Override
    public void parseWeatherDataFromDTU(String hexData) {
        WeatherPacket packet = ParseUpStreamInfoUtil.parseWeatherPacket(hexData);
        //LED
        //modbusService.sendWeatherDataToLedDisplay(packet);
        //推送和保存
        handlingService.storeAndPushWeatherData(packet);
    }
    /**
     * 解析0X07类型基站提交数据
     * @param hexData
     */
    @Override
    public void parseSubmitInfo(String hexData) {
        //result用作返回给网关
        String msg,result;
        //CRC校验不通过
        if (!CRCValidationUtil.CRC16Validation(hexData)) {
            msg = "fffe050a0802";
        } else {
            //如果是有效信息就做下一步操作，否则直接返回。
            if (ParseUpStreamInfoUtil.isValidInfo(hexData)) {
                List<Packet> packets = ParseUpStreamInfoUtil.parseGatewayPackets(hexData);
                //传给PLC
                modbusService.sendLoraDataToPLC(packets);
                //LED
                //modbusService.sendLoraDataToLedDisplay(packets);
                //保存到数据库和websocket推送
                handlingService.storeAndPushData(packets);
            }
            msg = "fffe050a0801";
        }
        result = msg + CRCValidationUtil.CRC16Validate(msg.substring(4));
        channel = ChannelCache.getChannelByName("01");
        ParseUtil.sendMsgThroughChannel(channel,result);
    }
    /**
     * 解析0X01心跳数据
     * @param hexData
     */
    @Override
    public void parseHeartbeatInfo(String hexData) {
        String msg, result;
        if (CRCValidationUtil.CRC16Validation(hexData)) {
            //noinspection SpellCheckingInspection
            msg = "fffe040a02";
            result = msg + CRCValidationUtil.CRC16Validate(msg);
            ParseUtil.sendMsgThroughChannel(channel,result);
        }
    }
    /**
     * 解析0X03请求授时数据
     * @param hexData
     */
    @Override
    public void parseTimeRequestInfo(String hexData) {
        String msg,result;
        if (CRCValidationUtil.CRC16Validation(hexData)) {
            //noinspection SpellCheckingInspection
            msg = "fffe0a0a04";
            result = msg + ParseUtil.parseDateToHexString(new Date()) + CRCValidationUtil.CRC16Validate(msg);
            ParseUtil.sendMsgThroughChannel(channel,result);
        }
    }
    /**
     * 解析0X05基站登陆基站MD5登陆
     * @param hexData 24是报文长度，不包括fffe和24，16进制的24对应10进制36+3=39，39*2=78，字符串的长度
     *                就是出去fffe和长度24这个部分，剩下部分的位数为24(16进制)
     */
    @Override
    public String parseLoginInfo(String hexData) {
        //msg用作返回给网关
        String msg,result;
        //CRC校验不通过
        if (!CRCValidationUtil.CRC16Validation(hexData)) {
            msg = "fffe050a0602";
            result = msg+CRCValidationUtil.CRC16Validate(msg.substring(4));
        } else {
            //网关ID
            String gateWayId = hexData.substring(10,26);
            //时间
            String loginTime = hexData.substring(30,42);
            //md5加密内容
            String md5Content = "4359494f5458"+loginTime+gateWayId;
            String md5Code = hexData.substring(42,74);
            //md5校验失败
            if (!md5Code.equals(MD5EncryptionUtil.encrypt(md5Content))) {
                msg = "fffe050a0604";
                result = msg+CRCValidationUtil.CRC16Validate(msg.substring(4));
            } else {
                msg = "fffe050a0601";
                //CRC16校验码只要四位，2个byte，所以我们把长度设为5个byte
                result = msg+ CRCValidationUtil.CRC16Validate(msg.substring(4));
            }
        }
        log.info(result);
        return result;
    }
    @Override
    public void parseAlarmInfo(String hexData) {
    }
    @Override
    public void parseResponseInfoForControl(String hexData) {
    }
    @Override
    public void parseResponseInfoForRetrieve(String hexData) {
    }
}
