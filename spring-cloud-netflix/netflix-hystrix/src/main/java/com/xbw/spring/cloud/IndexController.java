package com.xbw.spring.cloud;

import com.xbw.spring.cloud.remote.IndexRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    IndexRemote indexRemote;
	
    @RequestMapping("/index/{name}")
    public String index(@PathVariable("name") String name) {
        return indexRemote.index(name);
    }

    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name) {
        return indexRemote.hello(name);
    }

}
