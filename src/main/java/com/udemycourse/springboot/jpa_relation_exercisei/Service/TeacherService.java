package com.udemycourse.springboot.jpa_relation_exercisei.Service;


import com.udemycourse.springboot.jpa_relation_exercisei.Api.ApiException;
import com.udemycourse.springboot.jpa_relation_exercisei.DTO.IN.TeacherDTOIN;
import com.udemycourse.springboot.jpa_relation_exercisei.DTO.OUT.AddressDTOOUT;
import com.udemycourse.springboot.jpa_relation_exercisei.DTO.OUT.CourseDTOOUT;
import com.udemycourse.springboot.jpa_relation_exercisei.DTO.OUT.StudentDTOOUT;
import com.udemycourse.springboot.jpa_relation_exercisei.DTO.OUT.TeacherDTOOUT;
import com.udemycourse.springboot.jpa_relation_exercisei.Model.Course;
import com.udemycourse.springboot.jpa_relation_exercisei.Model.Teacher;
import com.udemycourse.springboot.jpa_relation_exercisei.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;

    // GET
    public List<TeacherDTOOUT> getAllTeachers() {
        return teacherRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // ADD
    public void addTeacher(TeacherDTOIN teacherDTOIN) {
        Teacher teacher = new Teacher();
        teacher.setName(teacherDTOIN.getName());
        teacher.setAge(teacherDTOIN.getAge());
        teacher.setEmail(teacherDTOIN.getEmail());
        teacher.setSalary(teacherDTOIN.getSalary());
        teacherRepository.save(teacher);
    }

    // UPDATE  TeacherDTOIN
    public void updateTeacher(Integer id, TeacherDTOIN teacherDTOIN) {
        Teacher teacher = teacherRepository.findTeacherById(id);
        if (teacher == null) {
            throw new ApiException("Teacher not found");
        }
        teacher.setName(teacherDTOIN.getName());
        teacher.setAge(teacherDTOIN.getAge());
        teacher.setEmail(teacherDTOIN.getEmail());
        teacher.setSalary(teacherDTOIN.getSalary());
        teacherRepository.save(teacher);
    }

    // DELETE
    public void deleteTeacher(Integer id) {
        Teacher teacher = teacherRepository.findTeacherById(id);
        if (teacher == null) {
            throw new ApiException("Teacher not found");
        }
        teacherRepository.delete(teacher);
    }

    // Get teacher details
    public TeacherDTOOUT getTeacherDetails(Integer id) {
        Teacher teacher = teacherRepository.findTeacherById(id);
        if (teacher == null) {
            throw new ApiException("Teacher not found");
        }
        return convertToDTO(teacher);
    }


    // Convert to DTO
    private TeacherDTOOUT convertToDTO(Teacher teacher) {

        // Address
        AddressDTOOUT addressDTOOUT = null;
        if (teacher.getAddress() != null) {
            addressDTOOUT = new AddressDTOOUT(
                    teacher.getAddress().getArea(),
                    teacher.getAddress().getStreet(),
                    teacher.getAddress().getBuildingNumber()
            );
        }

        // Courses
        List<CourseDTOOUT> courseDTOOUTS = teacher.getCourses() == null ?
                new ArrayList<>() :
                teacher.getCourses()
                        .stream()
                        .map(course -> {
                            Set<StudentDTOOUT> studentDTOOUTS = course.getStudents() == null ?
                                    new HashSet<>() :
                                    course.getStudents()
                                            .stream()
                                            .map(student -> new StudentDTOOUT(
                                                    student.getId(),
                                                    student.getName(),
                                                    student.getAge(),
                                                    student.getMajor()
                                            ))
                                            .collect(Collectors.toSet());

                            return new CourseDTOOUT(
                                    course.getId(),
                                    course.getName(),
                                    teacher.getName(),
                                    studentDTOOUTS
                            );
                        })
                        .collect(Collectors.toList());

        return new TeacherDTOOUT(
                teacher.getId(),
                teacher.getName(),
                teacher.getAge(),
                teacher.getEmail(),
                teacher.getSalary(),
                addressDTOOUT,
                courseDTOOUTS
        );
    }
}