package com.ljp.test.service;

/**
 * @author 罗俊平
 * @email 591402399@qq.com
 * @date 2021/3/14
 * @since 1.0.0
 **/
public interface ActivemqService {

    String sendMessageToQueue(String message);

    String sendMessageToTransactionQueue(String message);

}
