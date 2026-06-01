package com.udemycourse.springboot.jpa_relation_exercisei.DTO.OUT;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTOOUT {
    private Integer id;
    private String name;
    private String teacherName;
    private Set<StudentDTOOUT> students;
}