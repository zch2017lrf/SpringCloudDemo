package com.kaleldo.annotation;

import com.kaleldo.selector.KaleldoCloudApplicationSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(KaleldoCloudApplicationSelector.class)
public @interface KaleldoCloudApplication {
}
