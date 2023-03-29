package com.markus.netty.wechat.utils;

import com.markus.netty.wechat.common.Attributes;
import io.netty.channel.Channel;
import io.netty.util.Attribute;

/**
 * @author: markus
 * @date: 2023/3/29 8:11 AM
 * @Description: 登录相关操作的工具类
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class LoginUtils {

    public static void markAsLogin(Channel channel) {
        channel.attr(Attributes.LOGIN).set(true);
    }

    public static boolean hasLogin(Channel channel) {
        Attribute<Boolean> login = channel.attr(Attributes.LOGIN);
        // login 有值即表示登录成功
        return login.get() != null;
    }
}
