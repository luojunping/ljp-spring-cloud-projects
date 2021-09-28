package com.ljp.test.feign;

import com.ljp.common.constant.ServerUrlConsts;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 罗俊平
 * @email 591402399@qq.com
 * @date 2021/9/11
 * @since 1.0.0
 **/
@FeignClient(value = ServerUrlConsts.SERVER_NAME)
public interface FeignService {

    @GetMapping(value = "/ljp-server/test/get/simple")
    String getSimpleResult(@RequestParam("name") String name);

    @PostMapping(value = "/ljp-server/test/post/simple")
    String postSimpleResult(@RequestParam("name") String name);

    @PostMapping(value = "/ljp-server/test/post/json", produces = {"application/json; charset=UTF-8"})
    String postJsonResult(@RequestBody String name);

}
