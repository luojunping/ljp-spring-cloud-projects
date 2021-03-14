package com.ljp.test.controller;

import com.ljp.test.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class HelloWorldController {

    @Value("${server.port}")
    private String port;
    @Autowired
    private HelloWorldService helloWorldService;

    @GetMapping("/open/helloWorld")
    public String helloWorld(String name) {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 2; i++) {
            executorService.execute(() -> {
                String lockByRedis = helloWorldService.lockByRedis(UUID.randomUUID().toString().replace("-", ""));
                System.out.println("lockByRedis = " + lockByRedis);
            });
        }
        executorService.shutdown();
        return "helloWorld : " + name + "!!!";
    }

    @GetMapping("/test/gateway")
    // @DistributedLock("gateway")
    public String gateway(String name) {
        return "gateWay : " + port + " : " + name + "!!!";
    }

}
