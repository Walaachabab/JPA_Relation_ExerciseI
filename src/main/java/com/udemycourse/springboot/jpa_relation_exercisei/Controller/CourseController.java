package com.udemycourse.springboot.jpa_relation_exercisei.Controller;

import com.udemycourse.springboot.jpa_relation_exercisei.Api.ApiResponse;
import com.udemycourse.springboot.jpa_relation_exercisei.DTO.IN.CourseDTOIN;
import com.udemycourse.springboot.jpa_relation_exercisei.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/get")
    public ResponseEntity<?> getAllCourses() {
        return ResponseEntity.status(200).body(courseService.getAllCourses());
    }

    @PostMapping("/add/{teacherId}")
    public ResponseEntity<?> addCourse(@PathVariable Integer teacherId, @RequestBody @Valid CourseDTOIN courseDTOIN) {
        courseService.addCourse(teacherId, courseDTOIN);
        return ResponseEntity.status(200).body(new ApiResponse("Course added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable Integer id, @RequestBody @Valid CourseDTOIN courseDTOIN) {
        courseService.updateCourse(id, courseDTOIN);
        return ResponseEntity.status(200).body(new ApiResponse("Course updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Integer id) {
        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body(new ApiResponse("Course deleted successfully"));
    }

    // Get teacher name by course id
    @GetMapping("/teacher/{courseId}")
    public ResponseEntity<?> getTeacherNameByCourseId(@PathVariable Integer courseId) {
        return ResponseEntity.status(200).body(courseService.getTeacherNameByCourseId(courseId));
    }



    // Assign student to course
    @PutMapping("/assign/{courseId}/{studentId}")
    public ResponseEntity<?> assignStudentToCourse(@PathVariable Integer courseId,
                                                   @PathVariable Integer studentId) {
        courseService.assignStudentToCourse(courseId, studentId);
        return ResponseEntity.status(200).body(new ApiResponse("Student assigned to course successfully"));
    }





}
