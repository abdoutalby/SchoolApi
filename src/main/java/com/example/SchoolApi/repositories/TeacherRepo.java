package com.example.SchoolApi.repositories;

import com.example.SchoolApi.models.Class;
import com.example.SchoolApi.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

<<<<<<< HEAD
import java.util.Optional;

public interface TeacherRepo extends JpaRepository<Teacher,Long> {
    Optional<Teacher> findByNom(String nom);
=======
import java.util.List;
import java.util.Optional;

public interface TeacherRepo extends JpaRepository<Teacher,Long> {
    Optional<Teacher> findByEmailTeacher(String email);
    List<Teacher> findByNomTeacher(String nom);
>>>>>>> 91343ac42a09f2f5135eb666d577ad8285239f40
}
