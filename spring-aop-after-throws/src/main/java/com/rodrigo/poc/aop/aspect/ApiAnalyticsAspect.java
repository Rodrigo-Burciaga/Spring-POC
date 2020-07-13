package com.rodrigo.poc.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class ApiAnalyticsAspect {

    @Before("com.rodrigo.poc.aop.aspect.AopExpressions.forDaoPackageNoGetterAndSetter()")
    public void beforeAPIAnalytics() {
        System.out.println("\n======> Performing API analytics");

    }
}
