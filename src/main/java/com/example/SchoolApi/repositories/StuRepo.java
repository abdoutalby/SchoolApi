package com.example.SchoolApi.repositories;

import com.example.SchoolApi.models.Class;
import com.example.SchoolApi.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StuRepo extends JpaRepository<Student,Long> {
    Optional<Student> findByName(String name);
}

