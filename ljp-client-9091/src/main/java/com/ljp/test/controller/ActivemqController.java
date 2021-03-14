package com.ljp.test.controller;

import com.ljp.test.service.ActivemqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 罗俊平
 * @email 591402399@qq.com
 * @date 2021/3/10
 * @since 1.0.0
 **/
@RestController
public class ActivemqController {

    @Autowired
    private ActivemqService activemqService;

    @GetMapping("/test/activemq/send/text/message")
    public void sendTextMessage(@RequestParam("textMessage") String textMessage) {
        activemqService.sendTextMessage(textMessage);
    }

}
