package com.rodrigo.poc.java.pure.config.services;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "Today is your lucky day papi!";
    }
}
