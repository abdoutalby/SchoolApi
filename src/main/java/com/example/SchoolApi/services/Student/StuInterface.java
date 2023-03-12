package com.example.SchoolApi.services.Student;

import com.example.SchoolApi.models.Student;
import org.springframework.http.ResponseEntity;

public interface StuInterface {
    ResponseEntity<?> getAll();
    ResponseEntity<?> getById(Long id);
    ResponseEntity<?> add(Student addStudent);
    ResponseEntity<?> update(Student student,Long id);
    ResponseEntity<?> delete(Long id);
<<<<<<< HEAD
    ResponseEntity<?> findByName(String name);
=======
    ResponseEntity<?> findByName(String nom);
>>>>>>> 91343ac42a09f2f5135eb666d577ad8285239f40
}
