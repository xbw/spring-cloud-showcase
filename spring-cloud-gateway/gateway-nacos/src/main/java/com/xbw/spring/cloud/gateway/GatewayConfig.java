package com.xbw.spring.cloud.gateway;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

import java.util.Objects;

/**
 * @author xbw
 * @see org.springframework.cloud.gateway.config.PropertiesRouteDefinitionLocator
 */
@Configuration
public class GatewayConfig {


    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("nacos",
                        r -> r.path("/api/nacos/**")
                                .filters(f -> f.stripPrefix(2)
                                        .addResponseHeader("pom", "spring-cloud-starter-alibaba-nacos-discovery"))
                                .uri("lb://alibaba-nacos-producer"))
                .build();
    }

    @Bean
    KeyResolver userKeyResolver() {
        return exchange -> Mono.just(Objects.requireNonNull(exchange.getRequest().getRemoteAddress()).getAddress().getHostAddress());
    }
}
