package com.xbw.spring.cloud.remote.fallback;

import com.xbw.spring.cloud.remote.IndexRemote;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class RemoteIndexFallback implements IndexRemote {

    @Override
    public String index(@RequestParam(value = "name") String name) {
        return "Bad job " + name + "!, this message send failed ";
    }

    @Override
    public String hello(@RequestParam(value = "name") String name) {
        return "Bad " + name + "!, this message send failed ";
    }
}
