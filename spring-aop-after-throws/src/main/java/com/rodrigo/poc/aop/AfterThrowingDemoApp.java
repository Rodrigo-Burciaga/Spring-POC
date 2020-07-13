package com.rodrigo.poc.aop;

import com.rodrigo.poc.aop.dao.AccountDAO;
import com.rodrigo.poc.aop.entity.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterThrowingDemoApp {

    public static void main(String... args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        try {
            List<Account> accounts = accountDAO.findAccounts(true);
            System.out.println("\n\nMain Program: AfterThrowingDemoApp");
            System.out.println(accounts);
        } catch (Exception e) {
            System.err.println("Main program: catching exception " + e);
        }

        System.out.println("\n");
        context.close();
    }
}
