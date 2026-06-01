package com.udemycourse.springboot.jpa_relation_exercisei.DTO.OUT;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDTOOUT {
    private Integer id;
    private String name;
    private Integer age;
    private String email;
    private Double salary;

    private AddressDTOOUT address;
    private List<CourseDTOOUT> course;







}
