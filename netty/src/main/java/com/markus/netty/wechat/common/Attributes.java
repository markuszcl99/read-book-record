package com.markus.netty.wechat.common;

import io.netty.util.AttributeKey;

/**
 * @author: markus
 * @date: 2023/3/29 8:14 AM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public interface Attributes {
    AttributeKey<Boolean> LOGIN = AttributeKey.newInstance("login");
}
