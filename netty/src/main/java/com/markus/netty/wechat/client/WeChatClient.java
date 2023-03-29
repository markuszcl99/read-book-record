package com.markus.netty.wechat.client;

import com.markus.netty.wechat.client.handler.ClientHandler;
import com.markus.netty.wechat.protocol.PacketCodeC;
import com.markus.netty.wechat.protocol.command.MessageRequestCommand;
import com.markus.netty.wechat.utils.LoginUtils;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.Scanner;

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
        }).connect("127.0.0.1", 8081).addListener(future -> {
            if (future.isSuccess()) {
                // 如果连接成功 则开启控制台
                Channel channel = ((ChannelFuture) future).channel();
                startConsoleThread(channel);
            }
        });
    }

    private static void startConsoleThread(Channel channel) {
        new Thread(() -> {
            while (!Thread.interrupted()) {
                if (LoginUtils.hasLogin(channel)) {
                    System.out.println("通信连接成功，请在下方输入要发送的信息，并点击回车键发送");
                    Scanner scanner = new Scanner(System.in);
                    String line = scanner.nextLine();

                    MessageRequestCommand requestCommand = new MessageRequestCommand();
                    requestCommand.setMessageTxt(line);
                    ByteBuf byteBuf = PacketCodeC.INSTANCE.encode(requestCommand, channel.alloc());
                    channel.writeAndFlush(byteBuf);
                }
            }
        }).start();
    }
}
