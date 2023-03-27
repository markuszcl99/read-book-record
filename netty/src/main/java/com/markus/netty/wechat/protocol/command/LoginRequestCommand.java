package com.markus.netty.wechat.protocol.command;

import com.markus.netty.wechat.protocol.Command;
import com.markus.netty.wechat.protocol.Packet;
import lombok.Data;

/**
 * @author: markus
 * @date: 2023/3/27 9:58 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
@Data
public class LoginRequestCommand extends Packet {
    private String uuid;
    private String username;
    private String password;

    @Override
    public Byte getCommand() {
        return Command.LOGIN_REQUEST;
    }
}
