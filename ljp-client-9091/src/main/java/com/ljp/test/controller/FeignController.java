package com.ljp.test.controller;

import com.ljp.test.feign.FeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 罗俊平
 * @email 591402399@qq.com
 * @date 2021/9/11
 * @since 1.0.0
 **/
@RestController
public class FeignController {

    @Resource
    private FeignService feignService;

    @GetMapping(value = "/test/get/simple")
    public String getSimpleResult(String name) {
        return feignService.getSimpleResult(name);
    }

    @PostMapping(value = "/test/post/simple")
    public String postSimpleResult(String name) {
        return feignService.postSimpleResult(name);
    }

    @PostMapping(value = "/test/post/json", consumes = {"application/json; charset=UTF-8"})
    public String postJsonResult(String name) {
        return feignService.postJsonResult(name);
    }

}
