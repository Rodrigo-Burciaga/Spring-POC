package com.rodrigo.poc.java.pure.config;

import com.rodrigo.poc.java.pure.config.models.Coach;
import com.rodrigo.poc.java.pure.config.models.SwimCoach;
import com.rodrigo.poc.java.pure.config.services.FortuneService;
import com.rodrigo.poc.java.pure.config.services.SadFortuneService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.rodrigo.poc.java.pure.config")
@PropertySource("classpath:application.properties")
public class SportsConfig {

    @Bean
    public FortuneService sadFortuneService(){
        return new SadFortuneService();
    }

    @Bean
    public Coach swimCoach(){
        return new SwimCoach(sadFortuneService());
    }
}
