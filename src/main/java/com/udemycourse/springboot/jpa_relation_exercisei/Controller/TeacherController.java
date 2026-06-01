package com.udemycourse.springboot.jpa_relation_exercisei.Controller;

import com.udemycourse.springboot.jpa_relation_exercisei.Api.ApiResponse;
import com.udemycourse.springboot.jpa_relation_exercisei.DTO.IN.AddressDTOIN;
import com.udemycourse.springboot.jpa_relation_exercisei.DTO.IN.TeacherDTOIN;
import com.udemycourse.springboot.jpa_relation_exercisei.Service.AddressService;
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

    @GetMapping("/get")
    public ResponseEntity<?> getAllTeachers() {
        return ResponseEntity.status(200).body(teacherService.getAllTeachers());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addTeacher(@RequestBody @Valid TeacherDTOIN teacherDTOIN) {
        teacherService.addTeacher(teacherDTOIN);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateTeacher(@PathVariable Integer id,
                                           @RequestBody @Valid TeacherDTOIN teacherDTOIN) {
        teacherService.updateTeacher(id, teacherDTOIN);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTeacher(@PathVariable Integer id) {
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher deleted successfully"));
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<?> getTeacherDetails(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(teacherService.getTeacherDetails(id));
    }
}
