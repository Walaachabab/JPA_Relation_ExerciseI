package com.udemycourse.springboot.jpa_relation_exercisei.DTO.IN;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class StudentDTOIN {
    @NotEmpty(message = "Name must not be empty")
    private String name;


    @NotNull(message = "Age must not be empty")
    @Positive(message = "Age must be positive")
    private Integer age;

    @NotEmpty(message = "Major must not be empty")
    private String major;

}
