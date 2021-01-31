package com.ljp.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class HelloWorldController {

    @GetMapping("/open/helloWorld")
    public String helloWorld(String name) {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "helloWorld : " + name + "!!!";
    }

    @GetMapping("/test/gateway")
    public String gateWay(String name) {
        return "gateWay : " + name + "!!!";
    }

}
