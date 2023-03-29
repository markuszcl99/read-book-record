package com.markus.netty.wechat.server.handler;

import com.markus.netty.wechat.protocol.Packet;
import com.markus.netty.wechat.protocol.PacketCodeC;
import com.markus.netty.wechat.protocol.command.LoginRequestCommand;
import com.markus.netty.wechat.protocol.command.LoginResponseCommand;
import com.markus.netty.wechat.protocol.command.MessageRequestCommand;
import com.markus.netty.wechat.protocol.command.MessageResponseCommand;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author: markus
 * @date: 2023/3/27 10:11 PM
 * @Description: 服务端处理读写
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        Packet packet = PacketCodeC.INSTANCE.decode(byteBuf);
        if (packet instanceof LoginRequestCommand) {
            LoginRequestCommand login = (LoginRequestCommand) packet;
            System.out.println("服务端读取客户端数据 : " + login);

            LoginResponseCommand response = new LoginResponseCommand();
            if (checkLoginValid(login)) {
                response.setSuccess(true);
            } else {
                response.setSuccess(false);
                response.setMsg("登录信息校验失败！");
            }
            ByteBuf res = PacketCodeC.INSTANCE.encode(response, ctx.alloc());
            ctx.writeAndFlush(res);
        } else if (packet instanceof MessageRequestCommand) {
            MessageRequestCommand request = (MessageRequestCommand) packet;
            System.out.println("服务端接收到客户端发来的消息 : " + request.getMessageTxt());

            MessageResponseCommand response = new MessageResponseCommand();
            response.setResponse("服务端接收到客户端发送的消息了! 消息内容是 : [" + request.getMessageTxt() + "]");
            ByteBuf res = PacketCodeC.INSTANCE.encode(response, ctx.alloc());
            ctx.writeAndFlush(res);
        }
    }

    private boolean checkLoginValid(LoginRequestCommand command) {
        return true;
    }
}
