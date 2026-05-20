package com.udemycourse.springboot.jpa_relation_exercisei.Repository;


import com.udemycourse.springboot.jpa_relation_exercisei.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

    Teacher findTeacherById(Integer id);


}
