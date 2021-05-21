package com.ljp.common.configuration;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.transaction.TransactionManagerCustomizers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jms.connection.JmsTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.jms.ConnectionFactory;
import javax.sql.DataSource;

/**
 * @author 罗俊平
 * @email 591402399@qq.com
 * @date 2021/5/14
 * @since 1.0.0
 **/
@ConditionalOnClass({PlatformTransactionManager.class, ConnectionFactory.class, DataSource.class})
@Configuration(proxyBeanMethods = false)
public class TransactionManagerConfiguration {

    @Bean("jmsTransactionManager")
    PlatformTransactionManager jmsTransactionManager(ConnectionFactory connectionFactory) {
        return new JmsTransactionManager(connectionFactory);
    }

    @Bean("dataSourceTransactionManager")
    PlatformTransactionManager dataSourceTransactionManager(DataSource dataSource, ObjectProvider<TransactionManagerCustomizers> transactionManagerCustomizers) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(dataSource);
        transactionManagerCustomizers.ifAvailable((customizers) -> customizers.customize(dataSourceTransactionManager));
        return dataSourceTransactionManager;
    }

}
