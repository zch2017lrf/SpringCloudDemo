package com.kaleldo.auth;

import com.kaleldo.annotation.EnableKaleldoAuthExceptionHandler;
import com.kaleldo.annotation.EnableKaleldoServerProtect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@EnableKaleldoAuthExceptionHandler
@EnableKaleldoServerProtect
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }

}
