package com.rodrigo.poc.aop;

import com.rodrigo.poc.aop.dao.AccountDAO;
import com.rodrigo.poc.aop.dao.MembershipDAO;
import com.rodrigo.poc.aop.entity.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterReturningDemoApp {

    public static void main(String... args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        List<Account> accounts = accountDAO.findAccounts();

        System.out.println("\n\nMain Program: AfterReturningDemoApp");
        System.out.println(accounts);
        System.out.println("\n");
        context.close();
    }
}
