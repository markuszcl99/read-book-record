package com.markus.netty.wechat.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

/**
 * @author: markus
 * @date: 2023/3/27 10:16 PM
 * @Description: 将数据协议打包
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class PacketCodeC {
    private static int MAGIC_NUM = 0X12345678;

    public static ByteBuf encode(Packet packet) {
        // 申请一个ByteBuf
        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.ioBuffer();
        byte[] data = Serializer.DEFAULT.serialize(packet);
        // 1. 魔数
        byteBuf.writeInt(MAGIC_NUM);
        // 2. 版本
        byteBuf.writeByte(packet.getVersion());
        // 3. 序列化算法
        byteBuf.writeByte(SerializerAlgorithm.JSON);
        // 4. 数据长度
        byteBuf.writeInt(data.length);
        // 5. 数据
        byteBuf.writeBytes(data);
        return byteBuf;
    }

    public static <T> T decode(ByteBuf byteBuf, Class<T> clazz) {
        int magicNum = byteBuf.readInt();
        byte dataVersion = byteBuf.readByte();
        byte serializeAlgorithm = byteBuf.readByte();
        int len = byteBuf.readInt();
        byte[] data = new byte[len];
        byteBuf.readBytes(data);
        return Serializer.DEFAULT.deserialize(data, clazz);
    }
}
