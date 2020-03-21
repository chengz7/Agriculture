package com.farm.netty;
import com.farm.constant.TransmissionConstant;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.DecoderException;
import lombok.extern.slf4j.Slf4j;
import java.nio.ByteOrder;
import java.util.List;
/**
 * @Author: Rain
 * @Description: 针对LoRa网关和Modbus协议数据写的解码器
 * @Date: Created on 2019-04-25 15:48
 */
@Slf4j
public class FarmDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        Object decoded = this.decode(channelHandlerContext, byteBuf);
        if (decoded != null) {
            list.add(decoded);
        }
    }
    private Object decode(ChannelHandlerContext ctx, ByteBuf in) {
        //log.info(ctx.channel().remoteAddress().toString()+":"+ByteBufUtil.hexDump(in));
        String header = ByteBufUtil.hexDump(in, 0, 2);
        int readerIndex = in.readerIndex();
        if (header.equals(TransmissionConstant.LORA_MSG_HEADER)) {
            //帧长度
            long frameLength = getUnadjustedFrameLength(in, 2, 1, ByteOrder.BIG_ENDIAN);
            int frameLengthInt = (int) frameLength+3;
            if (frameLengthInt > in.readableBytes()) {
                in.readerIndex(in.writerIndex());
                return null;
            }
            ByteBuf frame = this.extractFrame(ctx, in, readerIndex, frameLengthInt);
            //移动读指针到写指针位置处,读写指针闭合
            in.readerIndex(readerIndex+frameLengthInt);
            return frame;
        } else if (header.equals(TransmissionConstant.MODBUS_READ_CODE)){
            long frameLength = getUnadjustedFrameLength(in, 2, 1, ByteOrder.BIG_ENDIAN);
            int frameLengthInt = (int)frameLength+TransmissionConstant.READ_CODE_EXTRA;
            if (frameLengthInt > in.readableBytes()) {
                in.readerIndex(in.writerIndex());
                return null;
            }
            ByteBuf frame = this.extractFrame(ctx, in, readerIndex, frameLengthInt);
            in.readerIndex(readerIndex + frameLengthInt);
            return frame;
        } else if (header.equals(TransmissionConstant.MODBUS_WRITE_CODE)||header.equals(TransmissionConstant.MODBUS_MULTI_WRITE_CODE)) {
            if (in.readableBytes() != TransmissionConstant.WRITE_REPLY_FRAME_LENGTH) {
                in.readerIndex(in.writerIndex());
                return null;
            } else {
                ByteBuf frame = this.extractFrame(ctx, in, readerIndex, TransmissionConstant.WRITE_REPLY_FRAME_LENGTH);
                in.readerIndex(readerIndex + TransmissionConstant.WRITE_REPLY_FRAME_LENGTH);
                return frame;
            }
        } else if (header.equals(TransmissionConstant.DTU_REGISTER_CODE)){
            ByteBuf frame = this.extractFrame(ctx, in, readerIndex, 8);
            in.readerIndex(in.writerIndex());
            return frame;
        }else {
            int writeIndex = in.writerIndex();
            in.readerIndex(writeIndex);
            return null;
        }
    }
    protected ByteBuf extractFrame(ChannelHandlerContext ctx, ByteBuf buffer, int index, int length) {
        return buffer.retainedSlice(index, length);
    }
    protected long getUnadjustedFrameLength(ByteBuf buf, int offset, int length, ByteOrder order) {
        buf = buf.order(order);
        long frameLength;
        switch(length) {
            case 1:
                frameLength = (long)buf.getUnsignedByte(offset);
                break;
            case 2:
                frameLength = (long)buf.getUnsignedShort(offset);
                break;
            case 3:
                frameLength = (long)buf.getUnsignedMedium(offset);
                break;
            case 4:
                frameLength = buf.getUnsignedInt(offset);
                break;
            case 5:
            case 6:
            case 7:
            default:
                throw new DecoderException("unsupported lengthFieldLength: " + length + " (expected: 1, 2, 3, 4, or 8)");
            case 8:
                frameLength = buf.getLong(offset);
        }
        return frameLength;
    }
}
