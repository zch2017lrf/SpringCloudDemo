package com.system.properties;

import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * 读取swagger配置文件管理类
 */
@Data
@SpringBootConfiguration
@PropertySource(value = {"classpath:kaleldo-server-system.properties"})
@ConfigurationProperties(prefix = "kaleldo.server.system")
public class KaleldoServerSystemProperties {
    /**
     * 免认证 URI，多个值的话以逗号分隔
     */
    private String anonUrl;

    private KaleldoSwaggerProperties swagger = new KaleldoSwaggerProperties();
}
