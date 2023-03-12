package com.example.SchoolApi.repositories;

import com.example.SchoolApi.models.Class;
import com.example.SchoolApi.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeacherRepo extends JpaRepository<Teacher,Long> {
    Optional<Teacher> findByNom(String nom);
}
