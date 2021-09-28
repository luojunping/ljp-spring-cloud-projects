package com.ljp.test.config;

import org.springframework.context.annotation.Configuration;

/**
 * @author 罗俊平
 * @email 591402399@qq.com
 * @date 2021/3/14
 * @since 1.0.0
 **/
@Configuration(proxyBeanMethods = false)
public class DestinationConfiguration {

    public static final String TEST_QUEUE = "test-queue";
    public static final String TEST_TOPIC = "test-topic";

    /*@Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public Destination testQueue() {
        return new ActiveMQQueue(DestinationConfiguration.TEST_QUEUE);
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public Destination testTopic() {
        return new ActiveMQTopic(DestinationConfiguration.TEST_TOPIC);
    }*/

}
