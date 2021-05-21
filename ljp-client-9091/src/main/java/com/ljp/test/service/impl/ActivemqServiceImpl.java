package com.ljp.test.service.impl;

import com.ljp.blog.dao.BlogDAO;
import com.ljp.blog.dto.BlogDTO;
import com.ljp.test.service.ActivemqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
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
    @Autowired
    private BlogDAO blogDAO;

    @Transactional(transactionManager = "jmsTransactionManager")
    @Override
    public void sendTextMessage(String textMessage) {
        jmsTemplate.send("my-queue", session -> session.createTextMessage(textMessage));
        saveBlog(textMessage);
    }

    @Transactional(transactionManager = "datasourceTransactionManager", propagation = Propagation.REQUIRES_NEW)
    public void saveBlog(String textMessage) {
        BlogDTO blogDTO = new BlogDTO();
        blogDTO.setBlogName("jms");
        blogDTO.setBlogContent("jms activemq");
        blogDTO.setCatalog("mq");
        blogDTO.setUserId("北漂二十年");
        blogDAO.insert(blogDTO);
        if ("world".equals(textMessage)) {
            throw new RuntimeException("activemq recover...");
        }
    }

}
