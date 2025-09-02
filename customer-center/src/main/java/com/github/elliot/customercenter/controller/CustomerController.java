package com.github.elliot.customercenter.controller;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/customer")
@RestController
public class CustomerController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-center}")
    private String serverURL;

    @GetMapping("/test/{message}")
    public String test(@PathVariable("message") String message) {
        String result = restTemplate.getForObject(serverURL + "/user/queryById/" + message, String.class);
        return "服务消费者调用返回--" + result;
    }

}
