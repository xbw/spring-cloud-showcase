package com.xbw.spring.cloud.gateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author xbw
 */
public class CustomGatewayFilter implements GatewayFilter, Ordered {
    private final Logger logger = LoggerFactory.getLogger(CustomGatewayFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.debug("CustomGatewayFilter before");
        return chain.filter(exchange).then(
                Mono.fromRunnable(() -> {
                    logger.debug("CustomGatewayFilter after");
                })
        );
    }

    @Override
    public int getOrder() {
        return Integer.MAX_VALUE;
    }
}
