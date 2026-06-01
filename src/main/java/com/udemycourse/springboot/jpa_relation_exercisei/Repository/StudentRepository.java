package com.udemycourse.springboot.jpa_relation_exercisei.Repository;


import com.udemycourse.springboot.jpa_relation_exercisei.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findStudentById(Integer id);
}
