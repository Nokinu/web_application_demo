package com.czhang.web_application_demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class SystemLogAspect {

    private static final Logger logger = LoggerFactory.getLogger(SystemLogAspect.class);

    String className, signature, methodDescription;

    private void generateMethodInfo(JoinPoint joinPoint) {
        className = joinPoint.getTarget().getClass().getName();
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        signature = methodSignature.getName();
        SystemLog systemLog = method.getAnnotation(SystemLog.class);
        methodDescription = systemLog.description();
    }

    @Pointcut("@annotation(SystemLog)")
    public void methodAspect() {
    }

    @Before("methodAspect()")
    public void before(JoinPoint joinPoint) {
        generateMethodInfo(joinPoint);
        try {
          logger.info("Start to process Class[{}] - Method[{}] - For[{}]", className, signature, methodDescription);
          //In real case, we can call logger service here to store log info.
        } catch (Exception exception) {
            logger.error("Logging for Class[{}] - Method[{}] - Failed For[{}]", className, signature, exception.toString());
        }
    }

    @AfterThrowing(pointcut = "methodAspect()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Throwable e) {
        generateMethodInfo(joinPoint);
        try {
            logger.info("Throwing Exception [{}] from Class[{}] - Method[{}] - For[{}]", e.getMessage(), className, signature, methodDescription);
            //In real case, we can call logger service here to store log info.
        } catch (Exception exception) {
            logger.error("Logging Exception [{}] for Class[{}] - Method[{}] - Failed For[{}]", e.getMessage(), className, signature, exception.toString());
        }
    }
}
