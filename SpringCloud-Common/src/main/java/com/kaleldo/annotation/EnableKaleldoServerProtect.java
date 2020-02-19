package com.kaleldo.annotation;

import com.kaleldo.configure.KaleldoServerProtectConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(KaleldoServerProtectConfigure.class)
public @interface EnableKaleldoServerProtect {
}
