package com.lammlai.springboot;

import com.lammlai.springboot.entity.Course;
import com.lammlai.springboot.entity.FullTimeEmployee;
import com.lammlai.springboot.entity.PartTimeEmployee;
import com.lammlai.springboot.entity.Student;
import com.lammlai.springboot.repository.CourseRepository;
import com.lammlai.springboot.repository.EmployeeRepository;
import com.lammlai.springboot.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {
//        courseRepository.playWithEntityManager();
//        studentRepository.saveStudentWithPassport();
//        courseRepository.addHardcodedReviewsForCourse();

//        List<Review> reviews = new ArrayList<>();
//        reviews.add(new Review("5", "Great Hands-on Stuff."));
//        reviews.add(new Review("5", "Hatsoff."));
//        courseRepository.addReviewsForCourse(10003L, reviews);

//        studentRepository.insertHardcodedStudentAndCourse();
//        studentRepository.insertStudentAndCourse(new Student("Jack"), new Course("Microservices in 100 Steps"));

//        employeeRepository.insert(new FullTimeEmployee("Jack", new BigDecimal("10000")));
//        employeeRepository.insert(new PartTimeEmployee("Jill", new BigDecimal("50")));
//        logger.info("Full Time Employees -> {}", employeeRepository.retrieveAllFullTimeEmployees());
//        logger.info("Part Time Employees -> {}", employeeRepository.retrieveAllPartTimeEmployees());
    }
}