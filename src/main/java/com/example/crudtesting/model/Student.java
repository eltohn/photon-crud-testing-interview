package com.example.crudtesting.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
//    @NotBlank(message = "Firstname cannot be Blank")
//    @NotEmpty(message = "Firstname cannot be Empty")
    private String  firstName;
//    @NotBlank(message = "Firstname cannot be Blank")
//    @NotEmpty(message = "Firstname cannot be Empty")
    private String lastName;
}
