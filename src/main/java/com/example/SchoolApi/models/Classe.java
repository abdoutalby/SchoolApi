package com.example.SchoolApi.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Classe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClass;
    @NonNull
    private String nomClass;
    @NonNull
    private String niveauClass;
    @OneToMany(mappedBy = "userClass")
    @JsonIgnore
    private List<Student> students=new ArrayList<>();
    @ManyToMany
    @JsonIgnore
    private List<Teacher> teachers=new ArrayList<>();


}

