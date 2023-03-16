package com.xbw.spring.cloud.gateway.filter;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Objects;

/**
 * @author xbw
 * @see org.springframework.cloud.gateway.filter.factory.RequestRateLimiterGatewayFilterFactory
 * @see org.springframework.cloud.gateway.filter.ratelimit.PrincipalNameKeyResolver  default implementation of KeyResolver
 * @Primary Parameter 1 of method requestRateLimiterGatewayFilterFactory in org.springframework.cloud.gateway.config.GatewayAutoConfiguration required a single bean
 */
@Component
@Primary
public class CustomKeyResolver implements KeyResolver {
    @Override
    public Mono<String> resolve(ServerWebExchange exchange) {
        String hostAddress = Objects.requireNonNull(exchange.getRequest().getRemoteAddress()).getAddress().getHostAddress();
        return Mono.just(hostAddress);
    }
}
