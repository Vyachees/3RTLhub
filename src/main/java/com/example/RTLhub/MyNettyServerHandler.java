package com.example.RTLhub;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * Handles a server-side channel.
 */
@Slf4j
public class MyNettyServerHandler extends SimpleChannelInboundHandler<String> {

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        String message = "message from server.";
        log.info("Sending message: " + message);
        ctx.writeAndFlush(message);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String message) {
        log.info("Received message: " + message);
        ctx.writeAndFlush(message+'\n');
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        log.info("Error in receiving message.");
        cause.printStackTrace();
        ctx.close();
    }


}
