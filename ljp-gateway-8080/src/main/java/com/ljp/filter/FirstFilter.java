package com.ljp.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class FirstFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        ServerHttpRequest request = exchange.getRequest();
//        HttpHeaders headers = request.getHeaders();
//        List<String> hello = headers.get("hello");
//        System.out.println(hello);
//        MultiValueMap<String, String> queryParams = request.getQueryParams();
//        System.out.println(queryParams);
        return chain.filter(exchange);
    }

}
