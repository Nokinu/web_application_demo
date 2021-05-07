package com.czhang.web_application_demo.aop;

import java.lang.annotation.*;

/**
 * Annotation for bloom filter for aop purpose
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BloomFilterLimit {

    String description() default "";
}
