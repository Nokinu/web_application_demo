package com.czhang.web_application_demo.aop;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * Annotation for redis lock
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RedisLock {

    // SPEL supported
    String value() default "";

    String lockKey() default "";

    long lockTime() default 20;

    TimeUnit lockTimeUnit() default TimeUnit.SECONDS;
}
