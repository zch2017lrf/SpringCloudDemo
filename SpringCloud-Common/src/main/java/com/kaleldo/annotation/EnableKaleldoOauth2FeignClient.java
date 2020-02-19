package com.kaleldo.annotation;

import com.kaleldo.configure.KaleldoOAuth2FeignConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(KaleldoOAuth2FeignConfigure.class)
public @interface EnableKaleldoOauth2FeignClient {
}
