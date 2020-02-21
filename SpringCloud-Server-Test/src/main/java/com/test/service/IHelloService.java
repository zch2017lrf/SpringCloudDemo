package com.test.service;

import com.test.fallback.HelloServiceFallback;
import com.kaleldo.pojo.KaleldoServerConstant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = KaleldoServerConstant.KALELDO_SERVER_SYSTEM, contextId = "helloServiceClient", fallbackFactory = HelloServiceFallback.class)
public interface IHelloService {

    /**
     * todo 出现版本问题
     * @RequestParam(required = false) String XXCode
     *
     * 这个参数少了个value = "XXCode", 这个是Spring 4.0版本后，@RequestParam 注解对参数传值有了很好的封装特性并严格校验。
     *
     * 改为：@RequestParam(value = "XXCode", required = false) String XXCode
     *
     * 之后，问题完美解决；重启项目正常。

     * @param name
     * @return
     */
    @GetMapping("hello")
    String hello(@RequestParam(value = "name", required = false)  String name);
}
