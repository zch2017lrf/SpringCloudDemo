package com.kaleldo.annotation;

import com.kaleldo.configure.KaleldoLettuceRedisConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(KaleldoLettuceRedisConfigure.class)
public @interface EnableKaleldoLettuceRedis {
}
