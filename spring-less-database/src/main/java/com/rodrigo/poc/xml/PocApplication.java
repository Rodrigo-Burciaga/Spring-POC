package com.rodrigo.poc.xml;

import com.rodrigo.poc.xml.models.Coach;
import com.rodrigo.poc.xml.models.CricketCoach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PocApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        // Constructor injection
        Coach coach = context.getBean("baseballCoach", Coach.class);
        System.out.println(coach.getDailyFortune());
        // Setter injection with injection values
        CricketCoach coach2 = context.getBean("cricketCoach", CricketCoach.class);
        System.out.println(coach2.getDailyFortune() + "- " + coach2.getDailyWorkout() + " injected values " +
                coach2.getEmail() + "- " + coach2.getTeam());
        context.close();
    }

}
