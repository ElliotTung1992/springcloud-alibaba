package com.github.elliot.customercenter.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "user-center")
public interface UserCenterService {

    @GetMapping(value = "/user/{id}")
    String queryById(@PathVariable("id") String id);
}
