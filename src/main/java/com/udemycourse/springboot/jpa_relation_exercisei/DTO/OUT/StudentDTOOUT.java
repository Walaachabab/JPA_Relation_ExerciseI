package com.udemycourse.springboot.jpa_relation_exercisei.DTO.OUT;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTOOUT {
    private Integer id;
    private String name;
    private Integer age;
    private String major;

}
