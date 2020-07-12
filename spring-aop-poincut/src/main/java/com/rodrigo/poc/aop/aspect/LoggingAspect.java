package com.rodrigo.poc.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution( * com.rodrigo.poc.aop.dao.*.*(..))")
    private void forDaoPackage() {
    }

    @Pointcut("execution( * com.rodrigo.poc.aop.dao.*.get*(..))")
    private void getter() {
    }

    @Pointcut("execution( * com.rodrigo.poc.aop.dao.*.set*(..))")
    private void setter() {
    }

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterAndSetter() {
    }

    @Before("forDaoPackageNoGetterAndSetter()")
    public void beforeAddAccount() {
        System.out.println("\n======> Performing API analytics");

    }
}
