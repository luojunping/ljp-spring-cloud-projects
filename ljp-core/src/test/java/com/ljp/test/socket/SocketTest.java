package com.ljp.test.socket;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * @author 罗俊平
 * @email 591402399@qq.com
 * @date 2021/7/3
 * @since 1.0.0
 **/
public class SocketTest {

    @Test
    public void testOne() throws IOException {
        Socket socket = new Socket("127.0.0.1", 8189);
        System.out.println("--------------------------------------");
        SocketAddress socketAddress = socket.getRemoteSocketAddress();
        System.out.println("socketAddress = " + socketAddress);
    }

    @Test
    public void testTwo() throws IOException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("127.0.0.1", 8189), 2 * 1000);
        System.out.println("--------------------------------------");
        SocketAddress socketAddress = socket.getRemoteSocketAddress();
        System.out.println("socketAddress = " + socketAddress);
    }

}
