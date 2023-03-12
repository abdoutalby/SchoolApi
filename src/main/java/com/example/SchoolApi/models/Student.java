package com.example.SchoolApi.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;


import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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


}
