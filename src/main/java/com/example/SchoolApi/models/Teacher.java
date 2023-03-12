package com.example.SchoolApi.models;

<<<<<<< HEAD
import jakarta.persistence.*;
=======
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
>>>>>>> 91343ac42a09f2f5135eb666d577ad8285239f40
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
<<<<<<< HEAD
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
=======
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

>>>>>>> 91343ac42a09f2f5135eb666d577ad8285239f40
}



