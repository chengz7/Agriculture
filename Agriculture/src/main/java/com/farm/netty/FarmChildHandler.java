package com.farm.netty;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
/**
 * @Author: Rain
 * @Description:
 * @Date: Created on 2019-04-25 15:54
 */
@Component
public class FarmChildHandler extends ChannelInitializer<SocketChannel> {
    @Resource
    private FarmHandler farmHandler;
    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        ChannelPipeline pipeline = channel.pipeline();
        pipeline.addLast(new FarmDecoder());
        pipeline.addLast(farmHandler);
    }
}
