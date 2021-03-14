package com.ljp.test.controller;

import com.ljp.common.constant.ServerUrlConsts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 * @author 罗俊平
 * @email 591402399@qq.com
 * @date 2021/2/27
 * @since 1.0.0
 **/
@RestController
public class RestTemplateController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/rest/where/from")
    public String fromWhere() {
        String result = restTemplate.getForObject(ServerUrlConsts.SERVER_URL + "rest/where/from", String.class);
        return result;
    }

}
