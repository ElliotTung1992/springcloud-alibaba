package com.github.elliot.customercenter.controller;

import com.github.elliot.customercenter.service.UserCenterService;
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

    @Value("${service-url.nacos-user-center}")
    private String serverURL;

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private UserCenterService userCenterService;

    @GetMapping("/test/{message}")
    public String test(@PathVariable("message") String message) {
        String result = restTemplate.getForObject(serverURL + "/user/queryById/" + message, String.class);
        return "服务消费者调用返回--" + result;
    }

    @GetMapping("/test2/{message}")
    public String test2(@PathVariable("message") String message) {
        long start = System.currentTimeMillis();
        String result = null;
        try {
            result = userCenterService.queryById(message);
        } catch (Exception e) {
            System.out.println(System.currentTimeMillis() - start);
            throw new RuntimeException(e);
        }
        return "服务消费者调用返回--" + result;
    }

}
