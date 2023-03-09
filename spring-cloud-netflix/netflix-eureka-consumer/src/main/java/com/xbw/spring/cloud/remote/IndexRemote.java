package com.xbw.spring.cloud.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "netflix-eureka-producer") // name is spring.application.name
public interface IndexRemote {
    @RequestMapping(value = "/index")
    String index(@RequestParam(value = "name") String name);

    @RequestMapping(value = "/hello")
    String hello(@RequestParam(value = "name") String name);
}
