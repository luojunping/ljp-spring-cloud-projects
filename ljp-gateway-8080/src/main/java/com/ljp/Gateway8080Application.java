package com.ljp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Gateway8080Application {

    public static void main(String[] args) {
        SpringApplication.run(Gateway8080Application.class, args);
    }

}
