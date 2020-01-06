package com.lammlai.springboot.repository;

import com.lammlai.springboot.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "courses")
public interface CourseSpringDataRepository extends JpaRepository<Course, Long> {

    List<Course> findByName(String name);

    List<Course> findByNameAndId(String name, Long id);

    int countByName(String name);

    List<Course> findByNameOrderByIdDesc(String name);

    List<Course> deleteByName(String name);

    @Query("select c from Course c where c.name like '%100 Steps'")
    List<Course> coursesWith100StepsInName();

    @Query(value = "select c from Course c where c.name like '%100 Steps'", nativeQuery = true)
    List<Course> coursesWith100StepsInNameUsingNativeQuery();

    @Query(name = "query_get_100_Step_courses")
    List<Course> coursesWith100StepsInNameUsingNamedQuery();

}
