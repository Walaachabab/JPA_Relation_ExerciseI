package com.udemycourse.springboot.jpa_relation_exercisei.DTO.IN;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTOIN {

    @NotEmpty(message = "Name must not be empty")
    private String name;
}