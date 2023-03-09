package com.xbw.spring.cloud;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping("/index")
    public String index(@RequestParam String name) {
        return "Good job " + name + "!，by producer";
    }

    @RequestMapping("/hello")
    public String hello(@RequestParam String name) {
        return "Hello " + name + "!，by producer";
    }
}
