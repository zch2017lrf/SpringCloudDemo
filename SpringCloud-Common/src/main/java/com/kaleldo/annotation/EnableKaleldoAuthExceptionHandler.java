package com.kaleldo.annotation;

import com.kaleldo.configure.KaleldoAuthExceptionConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(KaleldoAuthExceptionConfigure.class)
public @interface EnableKaleldoAuthExceptionHandler {
}
