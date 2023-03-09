package com.example.SchoolApi.services.Student;

import com.example.SchoolApi.models.Student;
import org.springframework.http.ResponseEntity;

public interface StuInterface {
    ResponseEntity<?> getAll();
    ResponseEntity<?> getById(Long id);
    ResponseEntity<?> add(Student student);
    ResponseEntity<?> update(Student student,Long id);
    ResponseEntity<?> delete(Long id);
    ResponseEntity<?> findByNomProd(String nom);
}
