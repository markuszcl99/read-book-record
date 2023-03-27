package com.markus.netty.wechat.protocol.command;

import com.markus.netty.wechat.protocol.Command;
import com.markus.netty.wechat.protocol.Packet;
import lombok.Data;

/**
 * @author: markus
 * @date: 2023/3/27 10:45 PM
 * @Description: 登录响应 指令
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
@Data
public class LoginResponseCommand extends Packet {
    private boolean success;
    private String msg;

    @Override
    public Byte getCommand() {
        return Command.LOGIN_RESPONSE;
    }
}
