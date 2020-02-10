package com.example.demo.controller;

import com.example.demo.service.AdminService;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.kaleldo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService;

    @GetMapping("user/{id}")
    public String getUser(@PathVariable Integer id) {

        return userService.get(id);
    }

    @RequestMapping(value = "hi", method = RequestMethod.GET)
    public String sayHi(@RequestParam String message) {
        return adminService.sayHi(message);
    }
}
