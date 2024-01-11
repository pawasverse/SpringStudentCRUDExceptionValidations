package com.dzooko.ms.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotEmpty(message = "sorry,field cannot be empty")
    @Size(max = 15, message = "sorry, too long")
    private String lastName;

    @Column(nullable = false)
    @NotEmpty(message = "sorry,field cannot be empty")
    @Size(max = 15, message = "sorry, too long")
    private String firstName;

    @Column(nullable = false, unique = true)
    @NotEmpty(message = "sorry,field cannot be empty")
    @Email(message = "not a valid email address")
    private String email;





}
