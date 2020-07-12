package com.rodrigo.poc.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class LoggingAspect {

    @Before("com.rodrigo.poc.aop.aspect.AopExpressions.forDaoPackageNoGetterAndSetter()")
    public void beforeAddAccount() {
        System.out.println("\n======> executing @Before advice on method");

    }

}
