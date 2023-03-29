package com.markus.netty.wechat.protocol;

import com.markus.netty.wechat.protocol.command.LoginRequestCommand;
import com.markus.netty.wechat.protocol.command.LoginResponseCommand;
import com.markus.netty.wechat.protocol.command.MessageRequestCommand;
import com.markus.netty.wechat.protocol.command.MessageResponseCommand;
import com.markus.netty.wechat.protocol.serializer.JsonSerializer;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

import java.util.HashMap;
import java.util.Map;

import static com.markus.netty.wechat.protocol.Command.*;

/**
 * @author: markus
 * @date: 2023/3/27 10:16 PM
 * @Description: 将数据协议打包
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class PacketCodeC {

    private static int MAGIC_NUM = 0X12345678;
    public static PacketCodeC INSTANCE = new PacketCodeC();

    private Map<Byte, Class<? extends Packet>> packetMap;
    private Map<Byte, Serializer> serializerMap;

    private PacketCodeC() {
        packetMap = new HashMap<>();
        packetMap.put(LOGIN_REQUEST, LoginRequestCommand.class);
        packetMap.put(LOGIN_RESPONSE, LoginResponseCommand.class);
        packetMap.put(MESSAGE_REQUEST, MessageRequestCommand.class);
        packetMap.put(MESSAGE_RESPONSE, MessageResponseCommand.class);

        serializerMap = new HashMap<>();
        serializerMap.put(SerializerAlgorithm.JSON, new JsonSerializer());
    }

    public ByteBuf encode(Packet packet, ByteBufAllocator allocator) {
        ByteBuf byteBuf = allocator.ioBuffer();
        byte[] data = Serializer.DEFAULT.serialize(packet);
        // 1. 魔数
        byteBuf.writeInt(MAGIC_NUM);
        // 2. 版本
        byteBuf.writeByte(packet.getVersion());
        // 3. 序列化算法
        byteBuf.writeByte(SerializerAlgorithm.JSON);
        // 4. 指令类型
        byteBuf.writeByte(packet.getCommand());
        // 5. 数据长度
        byteBuf.writeInt(data.length);
        // 6. 数据
        byteBuf.writeBytes(data);
        return byteBuf;
    }

    public Packet decode(ByteBuf byteBuf) {
        int magicNum = byteBuf.readInt();
        byte dataVersion = byteBuf.readByte();

        byte serializeAlgorithm = byteBuf.readByte();
        Serializer serializer = getSerializer(serializeAlgorithm);
        byte command = byteBuf.readByte();
        Class<? extends Packet> requestType = getRequestType(command);

        int len = byteBuf.readInt();
        byte[] data = new byte[len];
        byteBuf.readBytes(data);
        return serializer.deserialize(data, requestType);
    }

    private Class<? extends Packet> getRequestType(Byte command) {
        return packetMap.get(command);
    }

    private Serializer getSerializer(Byte serializeAlgorithm) {
        return serializerMap.get(serializeAlgorithm);
    }
}
