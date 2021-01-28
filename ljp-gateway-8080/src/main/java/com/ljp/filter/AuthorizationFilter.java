package com.ljp.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class AuthorizationFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        return chain.filter(exchange);
//        ServerHttpResponse response = exchange.getResponse();
//        ServerHttpRequest request = exchange.getRequest();
//        String token = request.getHeaders().getFirst("Authorization");
//        if (StringUtils.isBlank(token)) {
//            response.setStatusCode(HttpStatus.UNAUTHORIZED);
//            response.getHeaders().add("Content-Type", "application/json; charset=UTF-8");
//            return response.writeWith(Mono.just(response.bufferFactory().wrap("illegal access !!!".getBytes(StandardCharsets.UTF_8))));
//        }
//        try {
//            JWT.require(Algorithm.HMAC512("luojunping")).build().verify(token);
//            return chain.filter(exchange);
//        } catch (Exception e) {
//            response.setStatusCode(HttpStatus.UNAUTHORIZED);
//            response.getHeaders().add("Content-Type", "application/json; charset=UTF-8");
//            return response.writeWith(Mono.just(response.bufferFactory().wrap("illegal access !!!".getBytes(StandardCharsets.UTF_8))));
//        }
    }

}
