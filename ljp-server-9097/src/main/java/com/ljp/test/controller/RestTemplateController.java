package com.ljp.test.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 罗俊平
 * @email 591402399@qq.com
 * @date 2021/2/27
 * @since 1.0.0
 **/
@RestController
public class RestTemplateController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/rest/where/from")
    public String fromWhere() {
        return "i am from " + port;
    }

}
