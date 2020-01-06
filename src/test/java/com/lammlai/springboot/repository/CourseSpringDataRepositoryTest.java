package com.lammlai.springboot.repository;

import com.lammlai.springboot.Application;
import com.lammlai.springboot.entity.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class CourseSpringDataRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseSpringDataRepository repository;

    @Test
    public void findById_CoursePresent() {
        Optional<Course> courseOptional = repository.findById(10001L);
        assertTrue(courseOptional.isPresent());
    }

    @Test
    public void findById_CourseNotPresent() {
        Optional<Course> courseOptional = repository.findById(20001L);
        assertFalse(courseOptional.isPresent());
    }

    @Test
    public void playingAroundWithSpringDataRepository() {
//        Course course = new Course("Microservices in 100 Steps");
//        repository.save(course);
//
//        course.setName("Microservices in 100 Steps - Updated");
//        repository.save(course);

        logger.info("Courses -> {}", repository.findAll());
        logger.info("Count -> {}", repository.count());
    }

    @Test
    public void sort() {
        Sort sort = Sort.by(Sort.Direction.ASC, "name");
        logger.info("Sorted Courses -> {}", repository.findAll(sort));
        logger.info("Count -> {}", repository.count());
    }
}
