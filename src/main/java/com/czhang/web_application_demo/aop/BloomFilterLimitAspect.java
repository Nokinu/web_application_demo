package com.czhang.web_application_demo.aop;

import com.czhang.web_application_demo.filter.BloomFilterHandler;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Aspect
@Configuration
@Order(2)
public class BloomFilterLimitAspect {

    @Pointcut("@annotation(BloomFilterLimit)")
    public void ServiceAspect() {
    }

    @Around("ServiceAspect()")
    public Object around(ProceedingJoinPoint joinPoint) {
        Object[] objects = joinPoint.getArgs();
        Object title = objects[0];
        Object result;
        try {
            if (BloomFilterHandler.findDataByBloomFilter(title.toString())) {
                result = joinPoint.proceed();
            } else {
                throw new RuntimeException("Data is not available");
            }
        } catch (Throwable th) {
            throw new RuntimeException(th.getMessage());
        }
        return result;
    }
}
