package com.czhang.web_application_demo.aop;

import com.czhang.web_application_demo.utils.IPUtils;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.RateLimiter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.concurrent.TimeUnit;

@Aspect
@Configuration
@Order(1)
public class RateLimitAspect {

    private static final LoadingCache<String, RateLimiter> caches = CacheBuilder.newBuilder().maximumSize(1000).expireAfterWrite(1, TimeUnit.DAYS).build(new CacheLoader<String, RateLimiter>() {
        @Override
        public RateLimiter load(String s) {
            return RateLimiter.create(5);
        }
    });

    @Pointcut("@annotation(RateLimit)")
    public void ServiceAspect() {
    }

    @Around("ServiceAspect()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) {
        Object result;
        try {
            String key = IPUtils.getIpAddress();
            RateLimiter rateLimiter = caches.get(key);
            if(rateLimiter.tryAcquire()) {
                result = proceedingJoinPoint.proceed();
            } else {
                throw new RuntimeException("Too much request from one IP");
            }
        }catch (Throwable th) {
           throw new RuntimeException(th.getMessage());
        }
        return result;

    }

}
