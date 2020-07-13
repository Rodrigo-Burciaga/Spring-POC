package com.rodrigo.poc.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

    @Pointcut("execution( * com.rodrigo.poc.aop.dao.*.*(..))")
    public void forDaoPackage() {
    }

    @Pointcut("execution( * com.rodrigo.poc.aop.dao.*.get*(..))")
    public void getter() {
    }

    @Pointcut("execution( * com.rodrigo.poc.aop.dao.*.set*(..))")
    public void setter() {
    }

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterAndSetter() {
    }
}
