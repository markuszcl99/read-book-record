package com.markus.netty.wechat.client.handler;

import com.markus.netty.wechat.protocol.Packet;
import com.markus.netty.wechat.protocol.PacketCodeC;
import com.markus.netty.wechat.protocol.command.LoginRequestCommand;
import com.markus.netty.wechat.protocol.command.LoginResponseCommand;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.UUID;

/**
 * @author: markus
 * @date: 2023/3/27 10:14 PM
 * @Description: 客户端 处理读写
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端向服务端发起登录指令请求: ");
        LoginRequestCommand login = new LoginRequestCommand();
        login.setUuid(UUID.randomUUID().toString());
        login.setUsername("markuszhang");
        login.setPassword("123456");

        ByteBuf byteBuf = PacketCodeC.encode(login);
        // 向服务端写入
        ctx.writeAndFlush(byteBuf);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        LoginResponseCommand response = PacketCodeC.decode(byteBuf, LoginResponseCommand.class);
        if (response.isSuccess()) {
            System.out.println("客户端收到登录响应: 登录成功！");
        } else {
            System.out.println("客户端收到登录响应: 登录失败！错误信息为: " + response.getMsg());
        }
    }
}
