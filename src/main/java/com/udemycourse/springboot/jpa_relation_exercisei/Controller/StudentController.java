package com.udemycourse.springboot.jpa_relation_exercisei.Controller;

import com.udemycourse.springboot.jpa_relation_exercisei.Api.ApiResponse;
import com.udemycourse.springboot.jpa_relation_exercisei.DTO.IN.StudentDTOIN;
import com.udemycourse.springboot.jpa_relation_exercisei.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity<?> getAllStudents() {
        return ResponseEntity.status(200).body(studentService.getAllStudents());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addStudent(@RequestBody @Valid StudentDTOIN studentDTOIN) {
        studentService.addStudent(studentDTOIN);
        return ResponseEntity.status(200).body(new ApiResponse("Student added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Integer id,
                                           @RequestBody @Valid StudentDTOIN studentDTOIN) {
        studentService.updateStudent(id, studentDTOIN);
        return ResponseEntity.status(200).body(new ApiResponse("Student updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return ResponseEntity.status(200).body(new ApiResponse("Student deleted successfully"));
    }

    // Change student major
    @PutMapping("/major/{studentId}/{major}")
    public ResponseEntity<?> changeStudentMajor(@PathVariable Integer studentId,
                                                @PathVariable String major) {
        studentService.changeStudentMajor(studentId, major);
        return ResponseEntity.status(200).body(new ApiResponse("Student major changed successfully"));
    }

    // Get students by course id
    @GetMapping("/course/{courseId}")
    public ResponseEntity<?> getStudentsByCourseId(@PathVariable Integer courseId) {
        return ResponseEntity.status(200).body(studentService.getStudentsByCourseId(courseId));
    }
}
