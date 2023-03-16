package com.xbw.spring.cloud.gateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author xbw
 */
@Component
public class CustomGlobalFilter implements GlobalFilter, Ordered {
    private final Logger logger = LoggerFactory.getLogger(CustomGlobalFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.debug("CustomGlobalFilter before");
        return chain.filter(exchange).then(
                Mono.fromRunnable(() -> {
                    logger.debug("CustomGlobalFilter after");
                })
        );
    }

    @Override
    public int getOrder() {
        return Integer.MIN_VALUE;
    }
}
