package com.ljp.common.configuration;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
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
@ConditionalOnClass({JmsTransactionManager.class, DataSourceTransactionManager.class})
@Configuration(proxyBeanMethods = false)
@ConditionalOnBean({ConnectionFactory.class, DataSource.class})
public class TransactionManagerAutoConfiguration {

    @Bean("jmsTransactionManager")
    @ConditionalOnSingleCandidate(ConnectionFactory.class)
    PlatformTransactionManager jmsTransactionManager(ConnectionFactory connectionFactory) {
        return new JmsTransactionManager(connectionFactory);
    }

    @Bean("dataSourceTransactionManager")
    @ConditionalOnSingleCandidate(DataSource.class)
    PlatformTransactionManager dataSourceTransactionManager(DataSource dataSource, ObjectProvider<TransactionManagerCustomizers> transactionManagerCustomizers) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(dataSource);
        transactionManagerCustomizers.ifAvailable((customizers) -> customizers.customize(dataSourceTransactionManager));
        return dataSourceTransactionManager;
    }

}
