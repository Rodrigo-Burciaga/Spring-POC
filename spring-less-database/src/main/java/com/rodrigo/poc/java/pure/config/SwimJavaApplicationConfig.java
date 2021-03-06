package com.rodrigo.poc.java.pure.config;

import com.rodrigo.poc.java.pure.config.models.Coach;
import com.rodrigo.poc.java.pure.config.models.SwimCoach;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaApplicationConfig {

    public static void main(String... args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportsConfig.class);
        SwimCoach swimCoach = context.getBean("swimCoach", SwimCoach.class);
        System.out.println(swimCoach.getDailyFortune() + " " + swimCoach.getDailyWorkout());
        System.out.println(swimCoach.getEmail() + " " + swimCoach.getTeam());

        Coach coach = context.getBean("tennisCoach", Coach.class);
        System.out.println(coach.getDailyFortune() + " " + coach.getDailyWorkout());

        context.close();
    }
}
