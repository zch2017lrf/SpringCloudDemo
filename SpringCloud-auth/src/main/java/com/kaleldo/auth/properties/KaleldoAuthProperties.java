package com.kaleldo.auth.properties;

import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@Data
@SpringBootConfiguration
@PropertySource(value = {"classpath:kaleldo-auth.properties"})
@ConfigurationProperties(prefix = "kaleldo.auth")
public class KaleldoAuthProperties {

    //登录安全配置
    private KaleldoClientsProperties[] clients = {};
    private int accessTokenValiditySeconds = 60 * 60 * 24;
    private int refreshTokenValiditySeconds = 60 * 60 * 24 * 7;

    //验证码相关配置
    // 免认证路径
    private String anonUrl;

    private KaleldoValidateCodeProperties code = new KaleldoValidateCodeProperties();
}
