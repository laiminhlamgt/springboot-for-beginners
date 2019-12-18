package com.lammlai.springboot.repository;

import com.lammlai.springboot.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class CourseRepository {

    @Autowired
    EntityManager em;

    public Course findById(Long id) {
        return em.find(Course.class, id);
    }

//    public Course save(Course course) {
//        return null;
//    }

//    public void deleteById(Long id) {
//
//    }
}
