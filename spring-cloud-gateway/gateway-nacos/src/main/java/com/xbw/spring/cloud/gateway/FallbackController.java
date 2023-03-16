package com.xbw.spring.cloud.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xbw
 * @see org.springframework.cloud.gateway.filter.factory.SpringCloudCircuitBreakerFilterFactory
 * @see org.springframework.cloud.gateway.filter.factory.SpringCloudCircuitBreakerHystrixFilterFactory
 * @see org.springframework.cloud.gateway.filter.factory.SpringCloudCircuitBreakerResilience4JFilterFactory
 */
@RestController
@RequestMapping("/fallback")
public class FallbackController {

    @RequestMapping(value = {"", "/default"})
    public String fallback() {
        return "{\"msg\":\"The service is unavailable.\"}";
    }

    @GetMapping("/producer")
    public String producer() {
        return "{\"msg\":\"The Producer service is unavailable.\"}";
    }
}
