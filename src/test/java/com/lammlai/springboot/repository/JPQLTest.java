package com.lammlai.springboot.repository;

import com.lammlai.springboot.Application;
import com.lammlai.springboot.entity.Course;
import com.lammlai.springboot.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class JPQLTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    @Test
    public void jpql_basic() {
        List resultList = em.createNamedQuery("query_get_all_courses").getResultList();
        logger.info("select c from Course c -> {}", resultList);
    }

    @Test
    public void jpql_typed() {
        TypedQuery<Course> query = em.createNamedQuery("query_get_all_courses", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("select c from Course c -> {}", resultList);
    }

    @Test
    public void jpql_where() {
        TypedQuery<Course> query = em.createNamedQuery("query_get_100_Step_courses", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("select c from Course c where c.name like '%100 Steps' -> {}", resultList);
    }

    @Test
    public void jpql_courses_without_students() {
        TypedQuery<Course> query = em.createQuery("select c from Course c where c.students is empty", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Results -> {}", resultList);
    }

    @Test
    public void jpql_courses_without_atleast_2_students() {
        TypedQuery<Course> query = em.createQuery("select c from Course c where size(c.students) >= 2", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Results -> {}", resultList);
    }

    @Test
    public void jpql_courses_ordered_by_students() {
        TypedQuery<Course> query = em.createQuery("select c from Course c order by size(c.students) desc", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Results -> {}", resultList);
    }

    @Test
    public void jpql_students_with_passports_in_a_certain_pattern() {
        TypedQuery<Student> query = em.createQuery("select s from Student s where s.passport.number like '%1234%'", Student.class);
        List<Student> resultList = query.getResultList();
        logger.info("Results -> {}", resultList);
    }
    // like
    // between 100 and 1000
    // is null
    // upper, lower, trim, length

    // join => select c, s from Course c JOIN c.students s
    // left join => select c, s from Course c LEFT JOIN c.students s
    // cross join => select c, s from Course c, Students s
    // 3 and 4 => 3 * 4 = 12 rows
    @Test
    public void join() {
        Query query = em.createQuery("select c, s from Course c JOIN c.students s");
        List<Object[]> resultList = query.getResultList();
        logger.info("Results Size -> {}", resultList.size());
        for (Object[] result : resultList) {
            logger.info("Course{} Student{}", result[0], result[1]);
        }
    }

    @Test
    public void left_join() {
        Query query = em.createQuery("select c, s from Course c LEFT JOIN c.students s");
        List<Object[]> resultList = query.getResultList();
        logger.info("Results Size -> {}", resultList.size());
        for (Object[] result : resultList) {
            logger.info("Course{} Student{}", result[0], result[1]);
        }
    }

    @Test
    public void cross_join() {
        Query query = em.createQuery("select c, s from Course c, Student s");
        List<Object[]> resultList = query.getResultList();
        logger.info("Results Size -> {}", resultList.size());
        for (Object[] result : resultList) {
            logger.info("Course{} Student{}", result[0], result[1]);
        }
    }
}
