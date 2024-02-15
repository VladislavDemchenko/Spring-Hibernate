package com.example.demo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.function.Consumer;
import java.util.function.Function;

@SpringBootApplication
public class DemoSpringPracticesApplication {
    static EntityManager em;
    public static void main(String[] args) {
        SpringApplication.run(DemoSpringPracticesApplication.class, args);
    }


    public static void executeInTransaction(Consumer<EntityManager> entityManagerConsumer){
        executeInTransactionReturning(entityManager -> {
            entityManagerConsumer.accept(em);
            return null;
        });
    }

    public static <T>T executeInTransactionReturning(Function<EntityManager, T> entityManagerFunction){
        try {
            em.getTransaction().begin();
            var result = entityManagerFunction.apply(em);
            em.getTransaction().commit();
            return result;
        }catch (RuntimeException e){
            em.getTransaction().rollback();
            throw e;
        }
    }
    @Autowired
    public DemoSpringPracticesApplication(EntityManagerFactory entityManagerFactory) {
        em = entityManagerFactory.createEntityManager();
    }
}
