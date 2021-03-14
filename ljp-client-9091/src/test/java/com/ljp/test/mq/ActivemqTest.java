package com.ljp.test.mq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.jupiter.api.Test;

import javax.jms.*;

/**
 * @author 罗俊平
 * @email 591402399@qq.com
 * @date 2021/2/28
 * @since 1.0.0
 **/
public class ActivemqTest {

    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue("my-queue");
        for (int i = 0; i < 3; i++) {
            TextMessage textMessage = session.createTextMessage("hello world " + i);
            MessageProducer messageProducer = session.createProducer(queue);

            messageProducer.send(textMessage);
            // messageProducer.send(textMessage);
        }
        session.commit();
        // session.rollback();
        session.close();
        connection.close();
    }

    @Test
    public void testOne() throws JMSException {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue("my-queue");
        MessageConsumer messageConsumer = session.createConsumer(queue);
        for (int i = 0; i < 2; i++) {
            TextMessage textMessage = (TextMessage) messageConsumer.receive();
            session.commit();
            System.out.println("textMessage.getText() = " + textMessage.getText());
        }
        session.close();
        connection.close();
    }

    @Test
    public void testTwo() throws JMSException {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
//        Queue queue = session.createQueue("my-queue");
//        MessageConsumer messageConsumer = session.createConsumer(queue);
        session.setMessageListener(message -> {
            if (message.getClass().isAssignableFrom(TextMessage.class)) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println("textMessage.getText() = " + textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
//        messageConsumer.setMessageListener(message -> {
//            if (message.getClass().isAssignableFrom(TextMessage.class)) {
//                TextMessage textMessage = (TextMessage) message;
//                try {
//                    System.out.println("textMessage.getText() = " + textMessage.getText());
//                } catch (JMSException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        for (int i = 0; i < 2; i++) {
//            TextMessage textMessage = (TextMessage) messageConsumer.receive();
//            session.commit();
//            System.out.println("textMessage.getText() = " + textMessage.getText());
//        }
//        session.close();
//        connection.close();
    }

}
