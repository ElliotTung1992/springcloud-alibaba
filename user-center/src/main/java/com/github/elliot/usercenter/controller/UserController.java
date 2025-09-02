package com.github.elliot.usercenter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {

    @GetMapping(value = "/queryById/{id}")
    public String queryById(@PathVariable String id) {
        return "服务提供者：" + id;
    }

}
