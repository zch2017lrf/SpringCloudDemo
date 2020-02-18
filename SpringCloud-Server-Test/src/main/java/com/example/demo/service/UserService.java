package com.example.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("Server-System:8762")
public interface UserService {
    @GetMapping("user/{id}")
    public String get(@PathVariable("id") Integer id);
}
