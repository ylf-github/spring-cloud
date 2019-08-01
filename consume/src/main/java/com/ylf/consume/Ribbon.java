package com.ylf.consume;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: ylf
 * @Time: 2019/6/20 上午10:16
 * @Description:
 */
@RestController
public class Ribbon {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hi")
    @HystrixCommand(fallbackMethod = "hiError")
    public String hello(@RequestParam("id") String id){
        return restTemplate.getForObject("http://service-hi/hi?id="+id,String.class);
    }

    public String hiError(String name){
        return "hi "+name+" sorry error";
    }
}
