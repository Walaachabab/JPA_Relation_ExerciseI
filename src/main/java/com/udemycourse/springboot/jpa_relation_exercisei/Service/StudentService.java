package com.udemycourse.springboot.jpa_relation_exercisei.Service;


import com.udemycourse.springboot.jpa_relation_exercisei.Api.ApiException;
import com.udemycourse.springboot.jpa_relation_exercisei.DTO.IN.StudentDTOIN;
import com.udemycourse.springboot.jpa_relation_exercisei.DTO.OUT.StudentDTOOUT;
import com.udemycourse.springboot.jpa_relation_exercisei.Model.Course;
import com.udemycourse.springboot.jpa_relation_exercisei.Model.Student;
import com.udemycourse.springboot.jpa_relation_exercisei.Repository.CourseRepository;
import com.udemycourse.springboot.jpa_relation_exercisei.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    // GET
    public List<StudentDTOOUT> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // ADD
    public void addStudent(StudentDTOIN studentDTOIN) {
        Student student = new Student();
        student.setName(studentDTOIN.getName());
        student.setAge(studentDTOIN.getAge());
        student.setMajor(studentDTOIN.getMajor());
        studentRepository.save(student);
    }

    // UPDATE
    public void updateStudent(Integer id, StudentDTOIN studentDTOIN) {
        Student student = studentRepository.findStudentById(id);
        if (student == null) {
            throw new ApiException("Student not found");
        }
        student.setName(studentDTOIN.getName());
        student.setAge(studentDTOIN.getAge());
        student.setMajor(studentDTOIN.getMajor());
        studentRepository.save(student);
    }

    // DELETE
    public void deleteStudent(Integer id) {
        Student student = studentRepository.findStudentById(id);
        if (student == null) {
            throw new ApiException("Student not found");
        }
        studentRepository.delete(student);
    }

    // Change student major
    public void changeStudentMajor(Integer studentId, String major) {
        Student student = studentRepository.findStudentById(studentId);
        if (student == null) {
            throw new ApiException("Student not found");
        }
        // نحذف كل الكورسات المرتبطة بالطالب
        for (Course course : courseRepository.findAll()) {
            course.getStudents().remove(student);
            courseRepository.save(course);
        }
        // نغير التخصص
        student.setMajor(major);
        studentRepository.save(student);
    }

    // Get student list by course id
    public Set<StudentDTOOUT> getStudentsByCourseId(Integer courseId) {
        Course course = courseRepository.findCourseById(courseId);
        if (course == null) {
            throw new ApiException("Course not found");
        }
        return course.getStudents()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toSet());
    }

    // Convert to DTO
    private StudentDTOOUT convertToDTO(Student student) {
        return new StudentDTOOUT(
                student.getId(),
                student.getName(),
                student.getAge(),
                student.getMajor()
        );
    }






}
