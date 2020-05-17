package com.rodrigo.poc.java.pure.config.services;

public class SadFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "Today is a sad day!";
    }
}
