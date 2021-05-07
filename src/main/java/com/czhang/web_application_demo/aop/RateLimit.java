package com.czhang.web_application_demo.aop;

import java.lang.annotation.*;

/**
 * annotation for rate limit (IP based) as aop purpose
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RateLimit {

    String description() default "";

    String key() default "";

    LimitType limitType() default LimitType.IP;

    enum LimitType {
        IP,
    }
}
