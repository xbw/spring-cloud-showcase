package com.xbw.spring.cloud.gateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class PostGatewayFilterFactory extends AbstractGatewayFilterFactory<PostGatewayFilterFactory.Config> {

    private final Logger logger = LoggerFactory.getLogger(PostGatewayFilterFactory.class);

    public PostGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        logger.debug("PostGatewayFilterFactory before");
        // grab configuration from Config object
        return (exchange, chain) -> chain.filter(exchange).then(Mono.fromRunnable(() -> {
            logger.debug("PostGatewayFilterFactory after");
            ServerHttpResponse response = exchange.getResponse();
            //Manipulate the response in some way
        }));
    }

    public static class Config {
        //Put the configuration properties for your filter here
    }

}