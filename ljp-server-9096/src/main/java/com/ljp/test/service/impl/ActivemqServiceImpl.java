package com.ljp.test.service.impl;

import com.ljp.test.service.ActivemqService;
import org.springframework.stereotype.Service;

/**
 * @author 罗俊平
 * @email 591402399@qq.com
 * @date 2021/3/14
 * @since 1.0.0
 **/
@Service
public class ActivemqServiceImpl implements ActivemqService {

    /*@Resource
    private JmsTemplate jmsTemplate;
    @Resource
    private Destination testQueue;
    @Resource
    private Destination testTopic;
    @Resource
    private BlogDAO blogDAO;

    @Transactional(rollbackFor = Throwable.class)
    @Override
    public String sendMessageToQueue(String message) {
        jmsTemplate.convertAndSend(testQueue, message);
        jmsTemplate.convertAndSend(testTopic, message);
        if ("fail".equals(message)) {
            throw new RuntimeException("soft error...");
        }
        return "success";
    }

    @Transactional(rollbackFor = Throwable.class)
    @Override
    public String sendMessageToTransactionQueue(String message) {
        String result = "success";
        Connection connection = null;
        Session session = null;
        MessageProducer queueProducer = null;
        MessageProducer topicProducer = null;
        try {
            ConnectionFactory connectionFactory = jmsTemplate.getConnectionFactory();
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
            queueProducer = session.createProducer(testQueue);
            topicProducer = session.createProducer(testTopic);
            TextMessage textMessage = session.createTextMessage(message);
            queueProducer.send(textMessage, DeliveryMode.PERSISTENT, 9, 24 * 60 * 60 * 1000);
            topicProducer.send(textMessage, DeliveryMode.PERSISTENT, 9, 24 * 60 * 60 * 1000);
            BlogDTO blogDTO = new BlogDTO();
            blogDTO.setUserId(UUID.randomUUID().toString().replace("-", ""));
            blogDTO.setCatalog("java");
            blogDTO.setBlogName("think in java");
            blogDTO.setBlogContent("nio list set collection");
            blogDAO.insert(blogDTO);
            if ("fail".equals(message)) {
                throw new RuntimeException("soft error...");
            }
            session.commit();
        } catch (Throwable t) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            result = "fail";
            try {
                session.rollback();
            } catch (JMSException jmsException) {
                jmsException.printStackTrace();
            }
        } finally {
            try {
                topicProducer.close();
                queueProducer.close();
                session.close();
                connection.close();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
        return result;
    }*/

}
