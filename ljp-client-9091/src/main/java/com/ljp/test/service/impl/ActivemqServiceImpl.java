package com.ljp.test.service.impl;

import com.ljp.test.service.ActivemqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 罗俊平
 * @email 591402399@qq.com
 * @date 2021/3/10
 * @since 1.0.0
 **/
@Service
public class ActivemqServiceImpl implements ActivemqService {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Transactional
    @Override
    public void sendTextMessage(String textMessage) {
        jmsTemplate.send("my-queue", session -> {
            return session.createTextMessage(textMessage);
        });
        if ("world".equals(textMessage)) {
            throw new RuntimeException("activemq recover...");
        }
    }

}
