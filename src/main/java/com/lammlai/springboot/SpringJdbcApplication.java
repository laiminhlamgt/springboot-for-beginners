package com.lammlai.springboot;

import com.lammlai.springboot.entity.Person;
import com.lammlai.springboot.jdbc.PersonJdbcDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

//@SpringBootApplication
public class SpringJdbcApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PersonJdbcDao personJdbcDao;

    public static void main(String[] args) {
        SpringApplication.run(SpringJdbcApplication.class, args);
    }

    @Override
    public void run(String... args) {
        logger.info("All users -> {}", personJdbcDao.findAll());
        logger.info("User id 10001 -> {}", personJdbcDao.findById(10001));
        logger.info("Deleting 10002 -> No of Rows Deleted - {}", personJdbcDao.deleteById(10002));
        logger.info("Inserting 10004 -> {}", personJdbcDao.insert(new Person(10004, "Tara", "Berlin", new Date())));
        logger.info("Updating 10003 -> {}", personJdbcDao.update(new Person(10003, "Pieter", "Utrecht", new Date())));
    }
}