package com.rodrigo.poc.aop.aspect;

import com.rodrigo.poc.aop.entity.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class LoggingAspect {

    @AfterThrowing(
            pointcut = "execution(* com.rodrigo.poc.aop.dao.AccountDAO.findAccounts(..))",
            throwing = "except"
    )
    public void afterThrowingAdvice(JoinPoint joinPoint, Throwable except) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n======> executing @AfterThrowing on method: " + method);
        System.out.println("\n======> the exception is: " + except);
    }

    @AfterReturning(
            pointcut = "execution(* com.rodrigo.poc.aop.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n======> executing @AfterReturning on method: " + method);
        System.out.println("\n======> result is: " + result);

        convertNamesToUpperCase(result);

    }

    public void convertNamesToUpperCase(List<Account> result) {
        result.forEach(account -> account.setName(account.getName().toUpperCase()));
    }

    @Before("com.rodrigo.poc.aop.aspect.AopExpressions.forDaoPackageNoGetterAndSetter()")
    public void beforeAddAccount(JoinPoint joinPoint) {
        System.out.println("\n======> executing @Before advice on method");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println(arg);

            if (arg instanceof Account) {
                Account account = (Account) arg;
                System.out.println("account name: " + account.getName());
                System.out.println("account level: " + account.getLevel());
            }
        }
    }

}
