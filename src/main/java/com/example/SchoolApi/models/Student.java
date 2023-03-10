package com.example.SchoolApi.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Student {
    @UUID
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
    private String name;
    private int age;
    @ManyToOne(cascade =CascadeType.ALL )
    private Class userClass;


}
