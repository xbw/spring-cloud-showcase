package com.xbw.spring.cloud.gateway;

import com.xbw.spring.cloud.gateway.filter.CustomGatewayFilter;
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
                .route("eureka",
                        r -> r.path("/api/eureka/**")
                                .filters(f -> f.stripPrefix(2)
                                        .filter(new CustomGatewayFilter())
                                        .addResponseHeader("pom", "spring-cloud-starter-netflix-eureka-client"))
                                .uri("lb://netflix-eureka-producer"))
                .build();
    }

    @Bean
    KeyResolver userKeyResolver() {
        return exchange -> Mono.just(Objects.requireNonNull(exchange.getRequest().getRemoteAddress()).getAddress().getHostAddress());
    }
}
