package com.rodrigo.poc.xml;

import com.rodrigo.poc.xml.models.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

    public static void main(String... args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beanScopeApplicationContext.xml");

        Coach coach = context.getBean("baseballCoach", Coach.class);
        Coach coach1 = context.getBean("baseballCoach", Coach.class);
        System.out.println(coach == coach1);
        context.close();
    }
}
