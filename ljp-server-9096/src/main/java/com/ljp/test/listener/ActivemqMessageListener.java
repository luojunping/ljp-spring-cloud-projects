package com.ljp.test.listener;

import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

/**
 * @author 罗俊平
 * @email 591402399@qq.com
 * @date 2021/3/14
 * @since 1.0.0
 **/
@EnableJms
@Configuration(proxyBeanMethods = false)
public class ActivemqMessageListener {

    /*@Value("${spring.application.name}")
    private String clientId;

    @JmsListener(destination = DestinationConfiguration.TEST_QUEUE, containerFactory = "testQueueListenerContainerFactory")
    public void testQueue(TextMessage message) throws JMSException {
        // Object message = jmsTemplate.receiveAndConvert();
        System.out.println("test-queue = " + message.getText());
    }

    @JmsListener(destination = DestinationConfiguration.TEST_TOPIC, containerFactory = "testTopicListenerContainerFactory")
    public void testTopic(TextMessage message) throws JMSException {
        // Object message = jmsTemplate.receiveAndConvert();
        System.out.println("test-topic = " + message.getText());
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public DefaultJmsListenerContainerFactory testQueueListenerContainerFactory(JmsTemplate jmsTemplate) {
        DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactory = new DefaultJmsListenerContainerFactory();
        defaultJmsListenerContainerFactory.setConnectionFactory(Objects.requireNonNull(jmsTemplate.getConnectionFactory()));
        init(defaultJmsListenerContainerFactory);
        return defaultJmsListenerContainerFactory;
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public DefaultJmsListenerContainerFactory testTopicListenerContainerFactory(JmsTemplate jmsTemplate) {
        DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactory = new DefaultJmsListenerContainerFactory();
        defaultJmsListenerContainerFactory.setConnectionFactory(Objects.requireNonNull(jmsTemplate.getConnectionFactory()));
        defaultJmsListenerContainerFactory.setPubSubDomain(Boolean.TRUE);
        // defaultJmsListenerContainerFactory.setClientId(clientId);
        // defaultJmsListenerContainerFactory.setSubscriptionDurable(Boolean.TRUE);
        // init(defaultJmsListenerContainerFactory);
        return defaultJmsListenerContainerFactory;
    }

    private void init(DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactory) {
        defaultJmsListenerContainerFactory.setTaskExecutor(ThreadPoolExecutorUtils.create());
        defaultJmsListenerContainerFactory.setConcurrency(ThreadPoolExecutorUtils.CORE_SIZE + "-" + (ThreadPoolExecutorUtils.CORE_SIZE << 1));
        defaultJmsListenerContainerFactory.setSessionTransacted(Boolean.TRUE);
        defaultJmsListenerContainerFactory.setSessionAcknowledgeMode(Session.AUTO_ACKNOWLEDGE);
    }*/

}
