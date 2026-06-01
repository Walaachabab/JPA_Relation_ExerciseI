package com.udemycourse.springboot.jpa_relation_exercisei.DTO.IN;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDTOIN {

    @NotEmpty(message = "Name must not be empty")
    private String name;


    @NotNull(message = "Age must not be empty")
    @Positive(message = "Age must be positive")
    private Integer age;


    @NotEmpty(message = "Email must not be empty")
    @Email(message = "Email must be valid")
    private String email;


    @NotNull(message = "Salary must not be empty")
    @Positive(message = "Salary must be positive")
    private Double salary;





}
