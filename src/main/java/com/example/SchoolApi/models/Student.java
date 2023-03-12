package com.example.SchoolApi.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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


}
