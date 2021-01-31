package com.ljp.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class AuthorizationFilter implements GlobalFilter {

    @Value("jwt.algorithm.secret")
    private String secret;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String path = request.getURI().getPath();
        if (path.contains("/open/")) {
            return chain.filter(exchange);
        }
        ServerHttpResponse response = exchange.getResponse();
        String token = request.getHeaders().getFirst("Authorization");
        if (StringUtils.isBlank(token)) {
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            response.getHeaders().add("Content-Type", "application/json; charset=UTF-8");
            return response.writeWith(Mono.just(response.bufferFactory().wrap("illegal access !!!".getBytes(StandardCharsets.UTF_8))));
        }
        try {
            JWT.require(Algorithm.HMAC512(secret)).build().verify(token);
            return chain.filter(exchange);
        } catch (Exception e) {
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            response.getHeaders().add("Content-Type", "application/json; charset=UTF-8");
            return response.writeWith(Mono.just(response.bufferFactory().wrap("illegal access !!!".getBytes(StandardCharsets.UTF_8))));
        }
    }

}
