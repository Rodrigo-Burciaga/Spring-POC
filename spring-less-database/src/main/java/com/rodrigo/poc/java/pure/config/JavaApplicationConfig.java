package com.rodrigo.poc.java.pure.config;

import com.rodrigo.poc.java.pure.config.models.Coach;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaApplicationConfig {

    public static void main(String... args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportsConfig.class);
        Coach tennisCoach = context.getBean("tennisCoach", Coach.class);
        System.out.println(tennisCoach.getDailyFortune() + " " + tennisCoach.getDailyWorkout());
        context.close();
    }
}
