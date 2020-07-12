package com.rodrigo.poc.aop.dao;

import com.rodrigo.poc.aop.entity.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public void addAccount(Account account, boolean flag) {
        System.out.println(getClass() + " DOING MY DB WORK: ADDING ACCOUNT");
    }

    public boolean doWork(){
        System.out.println(getClass() + " doWork");
        return false;
    }
}
