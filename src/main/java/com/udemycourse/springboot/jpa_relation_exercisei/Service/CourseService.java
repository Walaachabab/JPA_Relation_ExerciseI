package com.udemycourse.springboot.jpa_relation_exercisei.Service;

import com.udemycourse.springboot.jpa_relation_exercisei.Api.ApiException;
import com.udemycourse.springboot.jpa_relation_exercisei.DTO.IN.CourseDTOIN;
import com.udemycourse.springboot.jpa_relation_exercisei.DTO.OUT.CourseDTOOUT;
import com.udemycourse.springboot.jpa_relation_exercisei.DTO.OUT.StudentDTOOUT;
import com.udemycourse.springboot.jpa_relation_exercisei.Model.Course;
import com.udemycourse.springboot.jpa_relation_exercisei.Model.Student;
import com.udemycourse.springboot.jpa_relation_exercisei.Model.Teacher;
import com.udemycourse.springboot.jpa_relation_exercisei.Repository.CourseRepository;
import com.udemycourse.springboot.jpa_relation_exercisei.Repository.StudentRepository;
import com.udemycourse.springboot.jpa_relation_exercisei.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;

    // GET
    public List<CourseDTOOUT> getAllCourses() {
        return courseRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // ADD "CourseDTOIN"
    public void addCourse(Integer teacherId, CourseDTOIN courseDTOIN) {
        Teacher teacher = teacherRepository.findTeacherById(teacherId);
        if (teacher == null) {
            throw new ApiException("Teacher not found");
        }
        Course course = new Course();
        course.setName(courseDTOIN.getName());
        course.setTeacher(teacher);
        courseRepository.save(course);
    }

    // UPDATE
    public void updateCourse(Integer id, CourseDTOIN courseDTOIN) {
        Course course = courseRepository.findCourseById(id);
        if (course == null) {
            throw new ApiException("Course not found");
        }
        course.setName(courseDTOIN.getName());
        courseRepository.save(course);
    }

    // Delete
    public void deleteCourse(Integer id) {
        Course course = courseRepository.findCourseById(id);
        if (course == null) {
            throw new ApiException("Course not found");
        }
        courseRepository.delete(course);
    }

    // Get teacher name by course id
    public String getTeacherNameByCourseId(Integer courseId) {
        Course course = courseRepository.findCourseById(courseId);
        if (course == null) {
            throw new ApiException("Course not found");
        }
        if (course.getTeacher() == null) {
            throw new ApiException("No teacher assigned to this course");
        }
        return course.getTeacher().getName();
    }

    // Convert to DTO
    private CourseDTOOUT convertToDTO(Course course) {
        String teacherName = course.getTeacher() == null ?
                "No teacher" : course.getTeacher().getName();

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
                teacherName,
                studentDTOOUTS
        );
    }





    public void assignStudentToCourse(Integer courseId, Integer studentId) {
        Course course = courseRepository.findCourseById(courseId);
        if (course == null) {
            throw new ApiException("Course not found");
        }
        Student student = studentRepository.findStudentById(studentId);
        if (student == null) {
            throw new ApiException("Student not found");
        }
        course.getStudents().add(student);
        courseRepository.save(course);
    }








}