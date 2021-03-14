package com.ljp.test.listener;

import com.ljp.util.ThreadPoolExecutorUtils;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;
import java.util.Objects;

/**
 * @author 罗俊平
 * @email 591402399@qq.com
 * @date 2021/3/14
 * @since 1.0.0
 **/
@EnableJms
@Configuration(proxyBeanMethods = false)
public class ActivemqMessageListener {

    @JmsListener(destination = "test-queue", containerFactory = "testQueueListenerContainerFactory")
    public static void testQueue(TextMessage message) throws JMSException {
        // Object message = jmsTemplate.receiveAndConvert();
        System.out.println("test-queue = " + message.getText());
    }

    @JmsListener(destination = "test-topic", containerFactory = "testTopicListenerContainerFactory")
    public static void testTopic(TextMessage message) throws JMSException {
        // Object message = jmsTemplate.receiveAndConvert();
        System.out.println("test-topic = " + message.getText());
    }

    private static void init(DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactory) {
        defaultJmsListenerContainerFactory.setTaskExecutor(ThreadPoolExecutorUtils.create());
        defaultJmsListenerContainerFactory.setConcurrency(ThreadPoolExecutorUtils.CORE_SIZE + "-" + (ThreadPoolExecutorUtils.CORE_SIZE << 1));
        defaultJmsListenerContainerFactory.setSessionTransacted(Boolean.TRUE);
        defaultJmsListenerContainerFactory.setSessionAcknowledgeMode(Session.AUTO_ACKNOWLEDGE);
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public DefaultJmsListenerContainerFactory testQueueListenerContainerFactory(JmsTemplate jmsTemplate) {
        DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactory = new DefaultJmsListenerContainerFactory();
        defaultJmsListenerContainerFactory.setConnectionFactory(Objects.requireNonNull(jmsTemplate.getConnectionFactory()));
        defaultJmsListenerContainerFactory.setPubSubDomain(false);
        init(defaultJmsListenerContainerFactory);
        return defaultJmsListenerContainerFactory;
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public DefaultJmsListenerContainerFactory testTopicListenerContainerFactory(JmsTemplate jmsTemplate) {
        DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactory = new DefaultJmsListenerContainerFactory();
        defaultJmsListenerContainerFactory.setConnectionFactory(Objects.requireNonNull(jmsTemplate.getConnectionFactory()));
        defaultJmsListenerContainerFactory.setPubSubDomain(true);
        init(defaultJmsListenerContainerFactory);
        return defaultJmsListenerContainerFactory;
    }

}
