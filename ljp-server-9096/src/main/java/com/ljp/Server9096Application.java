package com.ljp;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableDiscoveryClient
@EnableJms
@EnableAspectJAutoProxy(exposeProxy = true)
public class Server9096Application {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Server9096Application.class).web(WebApplicationType.SERVLET).run(args);
    }

}
