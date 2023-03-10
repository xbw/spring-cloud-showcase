package com.xbw.spring.cloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
@RefreshScope
public class IndexController {
    @Value("${user.name}")
    private String userName;
    @Value("${user.age}")
    private String userAge;

    @RequestMapping("")
    public String index() {
        return "user name :" + userName + "; age: " + userAge;
    }

}
