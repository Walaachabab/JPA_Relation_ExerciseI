package com.udemycourse.springboot.jpa_relation_exercisei.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

  //  @NotEmpty(message = "Name must not be empty")
    @Column(nullable = false)
    private String name;

//    @NotNull(message = "Age must not be empty")
//    @Positive(message = "Age must be positive")
    @Column(nullable = false)
    private Integer age;

//    @NotEmpty(message = "Email must not be empty")
//    @Email(message = "Email must be valid")
    @Column(nullable = false, unique = true)
    private String email;

//    @NotNull(message = "Salary must not be empty")
//    @Positive(message = "Salary must be positive")
    @Column(nullable = false)
    private Double salary;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "teacher")
   // @JsonIgnore
    private Address address;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "teacher")
   private List<Course> courses;
}
