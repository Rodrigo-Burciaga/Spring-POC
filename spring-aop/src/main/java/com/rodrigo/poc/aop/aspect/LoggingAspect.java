package com.rodrigo.poc.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution( * com.rodrigo.poc.aop.dao.*.*(..))")
    public void beforeAddAccount() {
        System.out.println("\n======> Executing @Before advice on method()");
    }
}
