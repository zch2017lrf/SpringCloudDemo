package com.example.demo.controller;

import com.example.demo.service.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private IHelloService helloService;

    @GetMapping("hello")
    public String hello(String name){
        String hello = this.helloService.hello(name);
        return hello;
    }
}
