package com.ljp.test.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 罗俊平
 * @email 591402399@qq.com
 * @date 2021/9/11
 * @since 1.0.0
 **/
@RestController
public class FeignController {

    @Value("${server.port:unknown}")
    private String serverPort;

    @GetMapping(value = "/test/get/simple")
    public String getSimpleResult(String name) {
        return serverPort + ": " + name;
    }

    @PostMapping(value = "/test/post/simple")
    public String postSimpleResult(String name) {
        return serverPort + ": " + name;
    }

    @PostMapping(value = "/test/post/json", consumes = {"application/json; charset=UTF-8"})
    public String postJsonResult(String name) {
        return serverPort + ": " + name;
    }

}
