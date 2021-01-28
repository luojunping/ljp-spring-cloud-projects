package com.ljp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author 罗俊平
 * @email 591402399@qq.com
 * @date 2021/1/23
 * @since 1.0.0
 **/
@SpringBootApplication
@EnableEurekaServer
public class Eureka8086Application {

    public static void main(String[] args) {
        SpringApplication.run(Eureka8086Application.class, args);
    }

}
