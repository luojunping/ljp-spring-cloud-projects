package com.ljp.test.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.jms.Destination;

/**
 * @author 罗俊平
 * @email 591402399@qq.com
 * @date 2021/3/14
 * @since 1.0.0
 **/
@Configuration(proxyBeanMethods = false)
public class DestinationConfiguration {

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public Destination testQueue() {
        return new ActiveMQQueue("test-queue");
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public Destination testTopic() {
        return new ActiveMQTopic("test-topic");
    }

}
