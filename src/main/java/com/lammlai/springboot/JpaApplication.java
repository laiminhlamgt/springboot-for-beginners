package com.lammlai.springboot;

import com.lammlai.springboot.entity.Person;
import com.lammlai.springboot.jpa.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

//@SpringBootApplication
public class JpaApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PersonJpaRepository personJpaRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @Override
    public void run(String... args) {
        logger.info("User id 10001 -> {}", personJpaRepository.findById(10001));
        logger.info("Inserting -> {}", personJpaRepository.insert(new Person("Tara", "Berlin", new Date())));
        logger.info("Updating 10003 -> {}", personJpaRepository.update(new Person(10003, "Pieter", "Utrecht", new Date())));
        personJpaRepository.deleteById(10002);
        logger.info("All users -> {}", personJpaRepository.findAll());
    }
}