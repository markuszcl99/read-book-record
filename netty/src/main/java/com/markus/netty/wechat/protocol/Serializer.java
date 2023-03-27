package com.markus.netty.wechat.protocol;

import com.markus.netty.wechat.protocol.serializer.JsonSerializer;

/**
 * @author: markus
 * @date: 2023/3/27 9:52 PM
 * @Description: 序列化器
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public interface Serializer {
    Serializer DEFAULT = new JsonSerializer();

    byte getSerializeAlgorithm();

    byte[] serialize(Object object);

    <T> T deserialize(byte[] data, Class<T> clazz);
}
