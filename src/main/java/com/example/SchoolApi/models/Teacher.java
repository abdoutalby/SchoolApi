package com.example.SchoolApi.models;

import jakarta.persistence.*;
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
    private long idt;
    private String nom;
    private String email_teacher;
    private String motDePasse_teacher;
    @ManyToMany
    @JoinColumn(name = "classes_id")
    private List<Class> classes= new ArrayList<>();
    @ManyToMany
    @JoinColumn(name = "students_id")
    private List<Student> students= new ArrayList<>();
}



