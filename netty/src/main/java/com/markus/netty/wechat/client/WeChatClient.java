package com.markus.netty.wechat.client;

import com.markus.netty.wechat.client.handler.ClientHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author: markus
 * @date: 2023/3/27 10:12 PM
 * @Description: 客户端
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class WeChatClient {
    public static void main(String[] args) {
        NioEventLoopGroup group = new NioEventLoopGroup();

        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group).channel(NioSocketChannel.class).handler(new ChannelInitializer<NioSocketChannel>() {
            @Override
            protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
                nioSocketChannel.pipeline().addLast(new ClientHandler());
            }
        }).connect("127.0.0.1", 8081);
    }
}
