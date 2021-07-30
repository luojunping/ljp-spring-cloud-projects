package com.ljp.common.configuration;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 罗俊平
 * @email 591402399@qq.com
 * @date 2021/5/21
 * @since 1.0.0
 **/
@Configuration(proxyBeanMethods = false)
public class RetryerConfiguration {

    @Bean
    public Retryer feignRetryer() {
        return new Retryer.Default(500, 10000, 5);
    }

}
