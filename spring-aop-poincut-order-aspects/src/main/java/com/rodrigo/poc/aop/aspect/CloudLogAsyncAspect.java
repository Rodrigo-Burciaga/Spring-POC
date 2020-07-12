package com.rodrigo.poc.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class CloudLogAsyncAspect {

    @Before("com.rodrigo.poc.aop.aspect.AopExpressions.forDaoPackageNoGetterAndSetter()")
    public void logToCloudAsync() {
        System.out.println("\n======> logging to cloud in async fashion");

    }
}
