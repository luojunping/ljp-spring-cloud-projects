package com.ljp.common.configuration;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * @author 罗俊平
 * @email 591402399@qq.com
 * @date 2021/5/21
 * @since 1.0.0
 **/
@Component
public class CommonRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        Optional.ofNullable(requestAttributes).ifPresent(ra -> {
                    HttpServletRequest request = ra.getRequest();
                    template.header("Cookie", request.getHeader("Cookie"));
                }
        );
    }

}
