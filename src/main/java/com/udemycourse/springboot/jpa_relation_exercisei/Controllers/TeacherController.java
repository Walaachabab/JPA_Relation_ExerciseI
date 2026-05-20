package com.udemycourse.springboot.jpa_relation_exercisei.Controllers;

import com.udemycourse.springboot.jpa_relation_exercisei.Api.ApiResponse;
import com.udemycourse.springboot.jpa_relation_exercisei.Model.Teacher;
import com.udemycourse.springboot.jpa_relation_exercisei.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    // GET
    @GetMapping("/get")
    public ResponseEntity<?> getAllTeachers() {
        return ResponseEntity.status(200).body(teacherService.getAllTeachers());
    }

    // ADD
    @PostMapping("/add")
    public ResponseEntity<?> addTeacher(@RequestBody @Valid Teacher teacher) {
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher added successfully"));
    }

    // UPDATE
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateTeacher(@PathVariable Integer id, @RequestBody @Valid Teacher teacher) {
        teacherService.updateTeacher(id, teacher);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher updated successfully"));
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTeacher(@PathVariable Integer id) {
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher deleted successfully"));
    }

    // Get teacher details with address
    @GetMapping("/details/{id}")
    public ResponseEntity<?> getTeacherDetails(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(teacherService.getTeacherDetails(id));
    }
}
