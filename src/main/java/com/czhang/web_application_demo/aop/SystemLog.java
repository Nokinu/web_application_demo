package com.czhang.web_application_demo.aop;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemLog {
    String description() default "";
}
