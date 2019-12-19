package com.lammlai.springboot.repository;

import com.lammlai.springboot.entity.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional
public class CourseRepository {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    public Course findById(Long id) {
        return em.find(Course.class, id);
    }

    public Course save(Course course) {
        if (course.getId() == null) {
            em.persist(course);
        } else {
            em.merge(course);
        }

        return course;
    }

    public void deleteById(Long id) {
        Course course = findById(id);
        em.remove(course);
    }

    public void playWithEntityManager() {
        Course course1 = new Course("Web Services in 100 Steps");
        em.persist(course1);
        em.flush();

        course1.setName("Web Services in 100 Steps - Updated");
        em.flush();

        Course course2 = new Course("Angular Js in 100 Steps");
        em.persist(course2);

        em.flush();

        course1.setName("Web Services in 100 Steps - Updated 3");
        course2.setName("Angular Js in 100 Steps - Updated 3");
        em.refresh(course1);

        em.flush();

        em.detach(course2);

        course2.setName("Angular Js in 100 Steps - Updated");
        em.flush();

        Course course3 = new Course("React Js in 100 Steps");
        em.persist(course3);
        em.flush();

        em.clear();

        course1.setName("Web Services in 100 Steps - Updated 1");
        course2.setName("Angular Js in 100 Steps - Updated 1");
        course3.setName("React Js in 100 Steps - Updated 1");
        em.flush();
    }
}
