package com.example.SchoolApi.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.lang.reflect.Array;
import java.util.ArrayList;


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
    @OneToMany
    private ArrayList<Student> students=new ArrayList<>();

}

