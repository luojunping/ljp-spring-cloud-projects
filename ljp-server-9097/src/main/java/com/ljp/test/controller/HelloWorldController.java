package com.ljp.test.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class HelloWorldController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/open/helloWorld")
    public String helloWorld(String name) {
        return "helloWorld : " + name + "!!!";
    }

    @GetMapping("/test/gateway")
    // @DistributedLock("gateway")
    public String gateway(String name) {
        System.out.println("------------" + port);
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("============" + port);
        return "gateWay : " + port + " : " + name + "!!!";
    }

}
