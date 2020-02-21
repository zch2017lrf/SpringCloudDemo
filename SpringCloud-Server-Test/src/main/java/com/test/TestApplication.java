package com.test;

import com.kaleldo.annotation.KaleldoCloudApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@EnableDiscoveryClient
@EnableFeignClients
@EnableGlobalMethodSecurity(prePostEnabled = true)
//@EnableKaleldoAuthExceptionHandler//认证类型异常翻译
//@EnableKaleldoOauth2FeignClient//开启带令牌的Feign请求，避免微服务内部调用出现401异常
//@EnableKaleldoServerProtect//开启微服务防护，避免客户端绕过网关直接请求微服务
@KaleldoCloudApplication
@SpringBootApplication
public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

}
