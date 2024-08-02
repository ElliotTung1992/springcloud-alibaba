package com.github.elliot.alibabasettlement.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/config")
public class ConfigController {

    @Value("${test.age:32}")
    private Integer age;

    @Value("${test.name:dge}")
    private String name;

    @RequestMapping("/get")
    public String get() {
        return name + age;
    }

}
