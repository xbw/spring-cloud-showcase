package com.xbw.spring.cloud.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author xbw
 */
@FeignClient(name = "alibaba-nacos-producer") // name is spring.application.name
public interface IndexRemote {

    @RequestMapping(value = "/hello")
    String hello(@RequestParam(value = "name") String name);
}
