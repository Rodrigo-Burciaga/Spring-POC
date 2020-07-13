package com.rodrigo.poc.aop.dao;

import com.rodrigo.poc.aop.entity.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;

    public List<Account> findAccounts() {
        List<Account> myAccounts = new ArrayList<>();
        Account account = new Account("John", "Silver");
        Account account2 = new Account("Rodrigo", "Platinum");
        Account account3 = new Account("Richard", "Gold");
        myAccounts.add(account);
        myAccounts.add(account2);
        myAccounts.add(account3);


        return myAccounts;
    }

    public void addAccount(Account account, boolean flag) {
        System.out.println(getClass() + " DOING MY DB WORK: ADDING ACCOUNT");
    }

    public boolean doWork() {
        System.out.println(getClass() + " doWork");
        return false;
    }

    public String getName() {
        System.out.println(getClass() + " in  getName");

        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + " in setName");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + " in getServiceCode");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + " in setServiceCode");
        this.serviceCode = serviceCode;
    }
}
