package com.markus.netty.wechat.protocol.command;

import com.markus.netty.wechat.protocol.Command;
import com.markus.netty.wechat.protocol.Packet;
import lombok.Data;

/**
 * @author: markus
 * @date: 2023/3/29 9:44 PM
 * @Description: 消息响应指令
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
@Data
public class MessageResponseCommand extends Packet {

    private String response;

    @Override
    public Byte getCommand() {
        return Command.MESSAGE_RESPONSE;
    }
}
