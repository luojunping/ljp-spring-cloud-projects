package com.ljp;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.web.client.RestTemplate;

/**
 * @author 罗俊平
 * @email 591402399@qq.com
 * @date 2021/2/1
 * @since 1.0.0
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableJms
public class Client9091Application {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Client9091Application.class).web(WebApplicationType.SERVLET).run(args);
    }

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
