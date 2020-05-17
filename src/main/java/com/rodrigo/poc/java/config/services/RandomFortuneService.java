package com.rodrigo.poc.java.config.services;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {

    private String[] fortunes = {
            "Beware of the wolf", "The journey is the reward", "Diligence is the mother of good luck"
    };
    private Random random = new Random();

    @Override
    public String getFortune() {
        int index = random.nextInt(fortunes.length);
        return fortunes[index];
    }
}
