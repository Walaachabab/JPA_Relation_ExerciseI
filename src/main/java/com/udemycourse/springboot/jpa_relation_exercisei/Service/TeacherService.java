package com.udemycourse.springboot.jpa_relation_exercisei.Service;


import com.udemycourse.springboot.jpa_relation_exercisei.Api.ApiException;
import com.udemycourse.springboot.jpa_relation_exercisei.Model.Teacher;
import com.udemycourse.springboot.jpa_relation_exercisei.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;

    // GET
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    // ADD
    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    // UPDATE
    public void updateTeacher(Integer id, Teacher teacher) {
        Teacher oldTeacher = teacherRepository.findTeacherById(id);
        if (oldTeacher == null) {
            throw new ApiException("Teacher not found");
        }
        oldTeacher.setName(teacher.getName());
        oldTeacher.setAge(teacher.getAge());
        oldTeacher.setEmail(teacher.getEmail());
        oldTeacher.setSalary(teacher.getSalary());
        teacherRepository.save(oldTeacher);
    }

    // DELETE
    public void deleteTeacher(Integer id) {
        Teacher teacher = teacherRepository.findTeacherById(id);
        if (teacher == null) {
            throw new ApiException("Teacher not found");
        }
        teacherRepository.delete(teacher);
    }

    // Get teacher details with address
    public Teacher getTeacherDetails(Integer id) {
        Teacher teacher = teacherRepository.findTeacherById(id);
        if (teacher == null) {
            throw new ApiException("Teacher not found");
        }
        return teacher;
    }
}
