package com.kaleldo.configure;

import com.kaleldo.interceptor.KaleldoServerProtectInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 加入到了Spring的拦截器链
 */
public class KaleldoServerProtectConfigure implements WebMvcConfigurer {

    @Bean
    public HandlerInterceptor febsServerProtectInterceptor() {
        return new KaleldoServerProtectInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(febsServerProtectInterceptor());
    }
}
