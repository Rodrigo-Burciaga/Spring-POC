package com.rodrigo.poc.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public void addSillyAccount(){
        System.out.println(getClass() + " DOING STUFF: ADDING MEMBERSHIP ACCOUNT");
    }

    public void goToSleep(){
        System.out.println(getClass() + " I'm going to sleep");
    }

}
