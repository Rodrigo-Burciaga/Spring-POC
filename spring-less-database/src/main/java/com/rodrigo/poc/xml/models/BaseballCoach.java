package com.rodrigo.poc.xml.models;


import com.rodrigo.poc.xml.services.FortuneService;

public class BaseballCoach implements Coach {

    private FortuneService fortuneService;

    public BaseballCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public String getDailyWorkout() {
        return "Practice batting 30 minutes at day";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    public void initMethod() {
        System.out.println("Initializing method");
    }

    public void destroyMethod() {
        System.out.println("Destroying method");
    }
}