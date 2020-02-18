package com.kaleldo.configure;

import com.kaleldo.handler.KaleldoAccessDeniedHandler;
import com.kaleldo.handler.KaleldoAuthExceptionEntryPoint;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

public class KaleldoAuthExceptionConfigure {


    /**
     * 当微服务系统的Spring IOC容器中没有名称为accessDeniedHandler的Bean的时候，
     * 就将KaleldoAccessDeniedHandler注册为一个Bean。
     * 这样做的好处在于，子系统可以自定义自个儿的资源服务器异常处理器，
     * 覆盖我们在common通用模块里定义的
     */
    @Bean
    @ConditionalOnMissingBean(name = "accessDeniedHandler")
    public KaleldoAccessDeniedHandler accessDeniedHandler() {
        return new KaleldoAccessDeniedHandler();
    }

    @Bean
    @ConditionalOnMissingBean(name = "authenticationEntryPoint")
    public KaleldoAuthExceptionEntryPoint authenticationEntryPoint() {
        return new KaleldoAuthExceptionEntryPoint();
    }
    /**
     * 接着定义一个注解来驱动该配置类
     */
}
