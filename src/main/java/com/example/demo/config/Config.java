package com.example.demo.config;


import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example.demo")
public class Config {
    @Bean
    public EntityManagerFactory emBean(){
        return Persistence.createEntityManagerFactory("default");
    }
}

