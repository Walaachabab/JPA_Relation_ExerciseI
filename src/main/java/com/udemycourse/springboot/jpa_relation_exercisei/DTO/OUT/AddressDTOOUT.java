package com.udemycourse.springboot.jpa_relation_exercisei.DTO.OUT;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTOOUT {
    private String area;
    private String street;
    private Integer buildingNumber;
}
