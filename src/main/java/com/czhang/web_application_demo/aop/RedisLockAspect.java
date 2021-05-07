package com.czhang.web_application_demo.aop;

import com.czhang.web_application_demo.utils.AOPUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.integration.redis.util.RedisLockRegistry;
import org.slf4j.*;
import java.lang.reflect.Method;
import java.util.concurrent.locks.Lock;

@Aspect
@Configuration
@Order(4)
public class RedisLockAspect {

    private final static Logger logger = LoggerFactory.getLogger(RedisLockAspect.class);
    private final RedisLockRegistry redisLockRegistry;

    public RedisLockAspect(RedisLockRegistry redisLockRegistry) {
        this.redisLockRegistry = redisLockRegistry;
    }

    @Pointcut("@annotation(RedisLock)")
    public void ServiceAspect() {
    }

    @Around("ServiceAspect()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Object[] args = proceedingJoinPoint.getArgs();
        RedisLock redisLock = method.getAnnotation(RedisLock.class);
        Object lockKey = AOPUtils.parseSpel(redisLock.lockKey(), method, args);
        Lock lock = redisLockRegistry.obtain(lockKey);
        Object result = null;
        try {
            boolean isLocked = lock.tryLock(redisLock.lockTime(), redisLock.lockTimeUnit());
            logger.info("Current thread [{}] 's lock result is {} ",Thread.currentThread().getName(), isLocked);
            if(isLocked) {
                result = proceedingJoinPoint.proceed();
            }
        } catch (Throwable e) {
          throw new RuntimeException(e.getMessage());
        } finally {
          try {
              lock.unlock();
          } catch (Exception ex) {
              logger.info("Current thread [{}] 's unlock exception {} ",Thread.currentThread().getName(), ex.getMessage());
          }
        }
        return result;
    }
}
