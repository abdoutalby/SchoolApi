package com.example.SchoolApi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTeacher;
    private String nomTeacher;
    @Email
    private String emailTeacher;
    @Size(min = 6)
    private String motDePasseTeacher;
    @ManyToMany
    @JsonIgnore
    private List<Classe> classes=new ArrayList<>();
   @ManyToMany
   @JsonIgnore
    private List<Student> students=new ArrayList<>();

}



