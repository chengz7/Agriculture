package com.farm.netty;
import com.farm.cache.ChannelCache;
import com.farm.constant.TransmissionConstant;
import com.farm.service.DataParsingService;
import com.farm.utils.ParseUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
/**
 * @Author: Rain
 * @Description: 业务处理的handler 日志打印不需要打印modbus回应信息帧，防止污染日志
 * @Date: Created on 2019-04-25 15:52
 */
@Component
@ChannelHandler.Sharable
@Slf4j
public class FarmHandler extends SimpleChannelInboundHandler<ByteBuf> {
    @Autowired
    private DataParsingService parsingService;
    private static FarmHandler farmHandler;
    @PostConstruct
    public void init() {
        farmHandler = this;
        farmHandler.parsingService = this.parsingService;
    }
    /**
     * fffe0103 java.lang.StringIndexOutOfBoundsException: String index out of range: 10
     * @param channelHandlerContext
     * @param msg
     */
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf msg) {
        String header = ByteBufUtil.hexDump(msg, 0, 2);
        byte[] byteMsg = new byte[msg.readableBytes()];
        msg.readBytes(byteMsg);
        String message = ByteBufUtil.hexDump(byteMsg);
        //LoRa信息帧
        if (header.equals(TransmissionConstant.LORA_MSG_HEADER)) {
            boolean flag = true;
            if (message != null && !message.isEmpty()) {
                if (message.length() < 6) {
                    flag = false;
                } else if (message.equals("fffe0103")){
                    flag = false;
                }else {
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
            if (flag) {
                //LoRa网关 05登陆请求直接处理
                if (ParseUtil.getDataType(message).equals("05")) {
                    ChannelCache.addChannel("01",channelHandlerContext.channel());
                    String result = parsingService.parseLoginInfo(message);
                    ByteBuf returnMsg = Unpooled.buffer();
                    returnMsg.writeBytes(ParseUtil.hexStringToBytes(result));
                    channelHandlerContext.channel().writeAndFlush(returnMsg);
                } else {
                    parsingService.parseDataFromGateway(message);
                }
            }
            //03功能码：故障设备状态/气象站传感器数据，需要解析
        } else if (header.equals(TransmissionConstant.MODBUS_READ_CODE)) {
            String flag = message.substring(4, 6);
            //故障状态、设备状态读取应答帧
            if (flag.equals("16")) {
                parsingService.parseErrorDataFromDtu(message);
            //有线传感器数据读取应答帧
            } else if (flag.equals("18")) {
                parsingService.parseWeatherDataFromDTU(message);
            } else {
            }
        //06功能码：无线水温应答帧/控制应答帧，不需要解析
        } else if (header.equals(TransmissionConstant.MODBUS_WRITE_CODE)) {
        //10功能码：LoRa传感器写入帧回应，不需要解析
        } else if (header.equals(TransmissionConstant.MODBUS_MULTI_WRITE_CODE)) {
        //DTU注册包
        }else if (header.equals(TransmissionConstant.DTU_REGISTER_CODE)){
            if (message.equals("3132303631323034")) {
                ChannelCache.addChannel("02",channelHandlerContext.channel());
            }
        }
        else {
            log.warn("异常信息"+"msg:"+message);
        }
    }
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info(ctx.channel().remoteAddress().toString() + "连接到服务器");
    }
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        ChannelCache.removeChannel(ctx.channel());
        log.info(ctx.channel().remoteAddress() + "断开连接");
    }
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        super.handlerRemoved(ctx);
        log.info(ctx.channel().remoteAddress()+"handlerRemoved");
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        // 出现异常就关闭
        cause.printStackTrace();
        log.warn(ctx.channel().remoteAddress() + "发生异常退出");
        ctx.close();
    }
}
