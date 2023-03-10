package com.xbw.spring.cloud;

import com.xbw.spring.cloud.remote.IndexRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class IndexController {
    @Value("${nacos.producer.name}")
    private String producerName;

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    IndexRemote indexRemote;

    @RequestMapping("/index/{name}")
    public String index(@PathVariable("name") String name) {
        String url = String.format("http://%s/index?name=%s", producerName, name);
        System.out.println(url);
        return restTemplate.getForObject(url, String.class);
    }

    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name) {
        return indexRemote.hello(name);
    }

}
