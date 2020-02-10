package com.example.demo.controller;


import com.kaleldo.pojo.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {

    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "hi", method = RequestMethod.GET)
    public String sayHi(@RequestParam(value = "message") String message) {
        return String.format("Hi，your message is : %s i am from port : %s", message, port);
    }
    @GetMapping("/user/{id:\\d+}")
    public String get(@PathVariable Integer id) {
        return new User(id, "kaleldo", "123456").toString();
    }
}