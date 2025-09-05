package com.github.elliot.usercenter.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class UserController {

    @Value("${work.address}")
    private String workAddress;

    @GetMapping(value = "/user/{id}")
    public String queryById(@PathVariable String id) throws InterruptedException {
        // TimeUnit.SECONDS.sleep(6);
        return "服务提供者：" + id;
    }

    @GetMapping(value = "/config/work/address")
    public String getConfig(){
        return workAddress;
    }

}
