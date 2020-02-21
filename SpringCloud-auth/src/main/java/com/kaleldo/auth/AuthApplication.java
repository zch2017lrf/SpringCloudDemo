package com.kaleldo.auth;

import com.kaleldo.annotation.EnableKaleldoAuthExceptionHandler;
import com.kaleldo.annotation.EnableKaleldoServerProtect;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@EnableKaleldoAuthExceptionHandler
@EnableKaleldoServerProtect
@MapperScan("com.kaleldo.auth.mapper")//将路径下的Mapper类都注册到IOC容器中
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }

}
