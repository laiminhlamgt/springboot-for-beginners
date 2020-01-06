package com.lammlai.springboot.repository;

import com.lammlai.springboot.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseSpringDataRepository extends JpaRepository<Course, Long> {
}
