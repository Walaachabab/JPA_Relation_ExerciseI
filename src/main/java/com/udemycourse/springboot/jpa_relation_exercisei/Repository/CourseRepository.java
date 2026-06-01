package com.udemycourse.springboot.jpa_relation_exercisei.Repository;


import com.udemycourse.springboot.jpa_relation_exercisei.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    Course findCourseById(Integer id);
}
