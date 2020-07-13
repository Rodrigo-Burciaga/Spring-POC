package com.rodrigo.poc.aop;

import com.rodrigo.poc.aop.dao.AccountDAO;
import com.rodrigo.poc.aop.dao.MembershipDAO;
import com.rodrigo.poc.aop.entity.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String... args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
        Account account = new Account();
        account.setName("Bari papa");
        account.setLevel("Platinum");
        accountDAO.doWork();

        accountDAO.setName("foobar");
        accountDAO.setServiceCode("silver");


        String name = accountDAO.getName();
        String serviceName = accountDAO.getServiceCode();

        accountDAO.addAccount(account, true);

        System.out.println("\n Testing again");

        membershipDAO.addSillyAccount();
        membershipDAO.goToSleep();
        context.close();
    }
}
