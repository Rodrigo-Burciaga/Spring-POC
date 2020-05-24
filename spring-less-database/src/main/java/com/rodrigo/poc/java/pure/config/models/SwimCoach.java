package com.rodrigo.poc.java.pure.config.models;

import com.rodrigo.poc.java.pure.config.services.FortuneService;
import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

    @Value("${foo.email}")
    private String email;
    @Value("${foo.team}")
    private String team;
    private FortuneService fortuneService;

    public SwimCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public String getEmail() {
        return email;
    }

    public String getTeam() {
        return team;
    }

    @Override
    public String getDailyWorkout() {
        return "swim 100 meters as a warm up,";
    }

    @Override
    public String getDailyFortune() {
        return this.fortuneService.getFortune();
    }
}
