package com.markus.netty.wechat.protocol.serializer;

import com.alibaba.fastjson.JSONObject;
import com.markus.netty.wechat.protocol.Serializer;
import com.markus.netty.wechat.protocol.SerializerAlgorithm;

/**
 * @author: markus
 * @date: 2023/3/27 10:01 PM
 * @Description: json序列化器
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class JsonSerializer implements Serializer {
    @Override
    public byte getSerializeAlgorithm() {
        return SerializerAlgorithm.JSON;
    }

    @Override
    public byte[] serialize(Object object) {
        return JSONObject.toJSONBytes(object);
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) {
        return JSONObject.parseObject(data, clazz);
    }
}
