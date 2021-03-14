package com.ljp.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloWorldController {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    private HelloWorldService helloWorldService;

    @GetMapping("/open/helloWorld")
    public String helloWorld(String name) {
        String forObject = restTemplate.getForObject("http://127.0.0.1:9096/ljp-server/open/helloWorld", String.class);
        return forObject;
        // return helloWorldService.helloWorld(name);
    }

    @GetMapping("/test/gateway")
    public String gateWay(String name) {
        return helloWorldService.gateWay(name);
    }

}
