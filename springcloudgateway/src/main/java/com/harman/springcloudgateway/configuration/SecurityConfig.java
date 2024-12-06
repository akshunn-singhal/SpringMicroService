package com.harman.springcloudgateway.configuration;

import com.harman.springcloudgateway.filter.JWTValidationFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder, JWTValidationFilter filter) {
        return builder.routes()
                .route("collateral-processing-route",
                        r -> r.path("/api/collateral/**")
                                .filters(f -> f.filter(filter))
                                .uri("http://localhost:8081/"))
                .route("loan-service-route",
                        r -> r.path("/api/loan/**")
                                .filters(f -> f.filter(filter))
                                .uri("http://localhost:8082/"))
                .route("risk-service-route",
                        r -> r.path("/api/risk/**")
                                .filters(f -> f.filter(filter))
                                .uri("http://localhost:8083/"))

                .build();
    }
}
