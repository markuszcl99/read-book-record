package com.markus.netty.demo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author: markus
 * @date: 2023/3/23 10:30 PM
 * @Description: 基于netty的服务端通信代码示例
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class NettyServer {
    public static void main(String[] args) {
        NioEventLoopGroup boss = new NioEventLoopGroup();
        NioEventLoopGroup worker = new NioEventLoopGroup();

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(boss, worker)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
                        System.out.println(123);
                        nioSocketChannel.pipeline().addLast(new NettyFirstServerHandler());
                    }
                }).bind(8080);
    }
}
