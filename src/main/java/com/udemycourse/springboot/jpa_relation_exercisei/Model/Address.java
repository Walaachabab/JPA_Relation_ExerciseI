package com.udemycourse.springboot.jpa_relation_exercisei.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {

    @Id
    private Integer id;

    @NotEmpty(message = "Area must not be empty")
    @Column(nullable = false)
    private String area;

    @NotEmpty(message = "Street must not be empty")
    @Column(nullable = false)
    private String street;

    @NotNull(message = "Building number must not be empty")
    @Positive(message = "Building number must be positive")
    @Column(nullable = false)
    private Integer buildingNumber;

    @OneToOne
    @MapsId
    @JoinColumn(name = "teacher_id")
    @JsonIgnore
    private Teacher teacher;
}