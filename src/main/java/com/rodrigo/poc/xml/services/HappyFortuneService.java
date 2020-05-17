package com.rodrigo.poc.xml.services;

public class HappyFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "Today is your lucky day";
    }
}
