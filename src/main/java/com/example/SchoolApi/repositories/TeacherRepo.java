package com.example.SchoolApi.repositories;

import com.example.SchoolApi.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TeacherRepo extends JpaRepository<Teacher,Long> {
    Optional<Teacher> findByEmailTeacher(String email);
    List<Teacher> findByNomTeacher(String nom);
}
