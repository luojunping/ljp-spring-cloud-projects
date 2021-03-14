package com.ljp.test.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author 罗俊平
 * @email 591402399@qq.com
 * @date 2021/2/11
 * @since 1.0.0
 **/
public class SelectorTest {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(6666), 200000);
        serverSocketChannel.configureBlocking(false);
        Selector selector = Selector.open();
        SelectionKey selectionKey = serverSocketChannel.register(selector, SelectionKey.OP_CONNECT);
        while (true) {
            int readyChannels = selector.select();
            if (readyChannels == 0) {
                continue;
            }
            Set<SelectionKey> selectedKeys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = selectedKeys.iterator();
            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();
                if (key.isAcceptable()) {
                    // a connection was accepted by a ServerSocketChannel.
                } else if (key.isConnectable()) {
                    // a connection was established with a remote server.
                } else if (key.isReadable()) {
                    // a channel is ready for reading
                } else if (key.isWritable()) {
                    // a channel is ready for writing
                }
                keyIterator.remove();
            }
        }
    }

}
