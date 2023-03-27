package com.markus.netty.wechat.protocol;

import io.netty.buffer.ByteBuf;
import lombok.Data;

/**
 * @author: markus
 * @date: 2023/3/27 9:53 PM
 * @Description: 数据包
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
@Data
public abstract class Packet {
    /**
     * 数据版本
     */
    public Byte version = 1;

    /**
     * 获取指令
     * @return
     */
    public abstract Byte getCommand();
}
