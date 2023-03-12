package com.example.SchoolApi.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;


import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
   private Long id;
    private String name;
    private int age;
    @ManyToOne
    @JoinColumn(name = "class_id")
    @JsonIgnore
    private Class userClass;
    @ManyToMany
    @JoinColumn(name = "teacher_id_teacher")
    private List<Teacher> teachers = new ArrayList<>();
=======
    private Long idStu;
    @NotNull
    private String nameStu;
    @NotNull
    private int ageStu;
    @ManyToOne
    private Classe userClass;

    @ManyToMany
    @JsonIgnore
    private List<Teacher> teachers=new ArrayList<>();
>>>>>>> 91343ac42a09f2f5135eb666d577ad8285239f40


}
