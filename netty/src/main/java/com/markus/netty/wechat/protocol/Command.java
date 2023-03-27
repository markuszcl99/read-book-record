package com.markus.netty.wechat.protocol;

/**
 * @author: markus
 * @date: 2023/3/27 9:49 PM
 * @Description: 指令
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public interface Command {
    /**
     * 登录请求 指令
     */
    Byte LOGIN_REQUEST = 1;

    /**
     * 登录响应 指令
     */
    Byte LOGIN_RESPONSE = 2;
}
