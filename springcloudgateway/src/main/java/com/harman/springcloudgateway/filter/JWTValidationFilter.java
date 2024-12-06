package com.harman.springcloudgateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class JWTValidationFilter implements GatewayFilter {

    //TODO move it to properties file and use value annotation
    private final static String AUTH_SERVER_BASE_URI = "http://localhost:8100/auth";
    private final static String AUTH_TOKEN_URI = "/token";

    private static Mono<Void> handleResponse(ServerWebExchange exchange, HttpStatus status) {
        exchange.getResponse().setStatusCode(status);
        return exchange.getResponse().setComplete();
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        RestTemplate template = new RestTemplate();
        String token = exchange.getRequest().getHeaders()
                .getFirst(HttpHeaders.AUTHORIZATION);
        StringBuilder url = new StringBuilder(AUTH_SERVER_BASE_URI)
                .append(AUTH_TOKEN_URI);
        token = token != null ? token.substring(7) : null;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "text/plain");
        HttpEntity<String> request = new HttpEntity<>(token, headers);
        try {
            ResponseEntity<Void> entity = template.postForEntity(url.toString(), request, Void.class);
            if (entity.getStatusCode().is2xxSuccessful()) {
                return chain.filter(exchange);
            } else {
                return handleResponse(exchange, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return handleResponse(exchange, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
