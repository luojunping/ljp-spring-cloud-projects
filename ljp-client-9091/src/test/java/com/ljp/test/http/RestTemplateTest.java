package com.ljp.test.http;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.nio.ByteBuffer;

/**
 * @author 罗俊平
 * @email 591402399@qq.com
 * @date 2021/2/27
 * @since 1.0.0
 **/
@SpringBootTest
public class RestTemplateTest {

    private static final String SERVER_URL = "http://LJP-SERVER/";

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void testOne() {
        String result = restTemplate.getForObject(SERVER_URL + "/rest/where/from", String.class);
        System.out.println("result = " + result);
    }

    @Test
    public void testTwo() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        byteBuffer.putInt(100);
        ByteBuffer readOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        System.out.println(readOnlyBuffer.getInt(0));
        byteBuffer.putInt(0, 150);
        System.out.println(readOnlyBuffer.getInt(0));
    }

}
