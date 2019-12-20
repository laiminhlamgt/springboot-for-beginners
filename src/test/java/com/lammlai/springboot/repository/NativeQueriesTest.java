package com.lammlai.springboot.repository;

import com.lammlai.springboot.Application;
import com.lammlai.springboot.entity.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class NativeQueriesTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    @Test
    public void native_queries_basic() {
        Query query = em.createNativeQuery("SELECT * FROM COURSE", Course.class);
        List resultList = query.getResultList();
        logger.info("SELECT * FROM COURSE -> {}", resultList);
    }

    @Test
    public void native_queries_with_parameter() {
        Query query = em.createNativeQuery("SELECT * FROM COURSE where id = ?", Course.class);
        query.setParameter(1, 10001L);
        List resultList = query.getResultList();
        logger.info("SELECT * FROM COURSE where id = ? -> {}", resultList);
    }

    @Test
    public void native_queries_with_named_parameter() {
        Query query = em.createNativeQuery("SELECT * FROM COURSE WHERE ID = :ID", Course.class);
        query.setParameter("ID", 10001L);
        List resultList = query.getResultList();
        logger.info("SELECT * FROM COURSE WHERE ID = :ID -> {}", resultList);
    }

    @Test
    @Transactional
    public void native_queries_to_update() {
        Query query = em.createNativeQuery("UPDATE COURSE SET LAST_UPDATED_DATE = SYSDATE()", Course.class);
        int numberOfRowsUpdated = query.executeUpdate();
        logger.info("numberOfRowsUpdated -> {}", numberOfRowsUpdated);
    }
}
