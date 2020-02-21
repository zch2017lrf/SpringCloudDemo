package com.test.service;

import com.test.fallback.HelloServiceFallback;
import com.kaleldo.pojo.KaleldoServerConstant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = KaleldoServerConstant.KALELDO_SERVER_SYSTEM, contextId = "userServiceClient", fallbackFactory = HelloServiceFallback.class)
public interface UserService {
    @GetMapping("user/{id}")
    public String get(@PathVariable("id") Integer id);
}
