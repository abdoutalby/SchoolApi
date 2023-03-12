package com.example.SchoolApi.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

import jakarta.persistence.Id;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CollectionType;


import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String niveau;
    @OneToMany(mappedBy = "userClass")
    @JsonIgnore
    private List<Student> students= new ArrayList<>();
    @ManyToMany
    @JoinColumn(name = "teachers_id_teacher")
    private List<Teacher> teachers=new ArrayList<>();

}

