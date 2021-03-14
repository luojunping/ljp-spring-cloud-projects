package com.ljp.test.controller;

import com.ljp.test.service.ActivemqService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 罗俊平
 * @email 591402399@qq.com
 * @date 2021/3/14
 * @since 1.0.0
 **/
@RestController
public class ActivemqController {

    @Resource
    private ActivemqService activemqService;

    @GetMapping("/test/queue/send/message")
    public String sendMessageToQueue(String message) {
        return activemqService.sendMessageToQueue(message);
    }

    @GetMapping("/test/transaction/queue/send/message")
    public String sendMessageToTransactionQueue(String message) {
        return activemqService.sendMessageToTransactionQueue(message);
    }

}
