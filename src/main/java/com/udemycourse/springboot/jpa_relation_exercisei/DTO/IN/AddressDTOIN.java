package com.udemycourse.springboot.jpa_relation_exercisei.DTO.IN;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTOIN {

    @NotEmpty(message = "Area must not be empty")
    private String area;

    @NotEmpty(message = "Street must not be empty")
    private String street;

    @NotNull(message = "Building number must not be empty")
    @Positive(message = "Building number must be positive")
    private Integer buildingNumber;
}
