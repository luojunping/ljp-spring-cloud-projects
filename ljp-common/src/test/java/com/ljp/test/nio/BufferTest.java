package com.ljp.test.nio;

import org.junit.jupiter.api.Test;

import java.nio.CharBuffer;

/**
 * @author 罗俊平
 * @email 591402399@qq.com
 * @date 2021/2/10
 * @since 1.0.0
 **/
public class BufferTest {

    @Test
    public void testOne() {
        CharBuffer charBuffer = CharBuffer.allocate(512);
        System.out.println("charBuffer.position() = " + charBuffer.position());
        System.out.println("charBuffer.limit() = " + charBuffer.limit());
        System.out.println("charBuffer.capacity() = " + charBuffer.capacity());
        System.out.println("charBuffer.length() = " + charBuffer.length());
        charBuffer.put('国');
        charBuffer.flip();
        System.out.println("charBuffer.get() = " + charBuffer.get());
    }

}
