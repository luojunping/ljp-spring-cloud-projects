package com.ljp.test.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "LJP-SERVER")
public interface HelloWorldService {

    @GetMapping("/open/helloWorld")
    String helloWorld(@RequestParam("name") String name);

    @GetMapping("/ljp-server/test/gateway")
    String gateWay(@RequestParam("name") String name);

}
