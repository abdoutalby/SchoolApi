package com.example.SchoolApi.services.ClasseService;

import com.example.SchoolApi.models.Classe;
import com.example.SchoolApi.utils.AddStudentRequest;
import org.springframework.http.ResponseEntity;

public interface claService {
    ResponseEntity<?> getAll();
    ResponseEntity<?> getById(Long id);
    ResponseEntity<?> create(Classe classe);
    ResponseEntity<?> update(Classe classe, Long id);
    ResponseEntity<?> delete(Long id);
    ResponseEntity<?> findByNiveau(String niveau);
    ResponseEntity<?> findByNom(String nom);
    ResponseEntity<?> getAllStudent(String nom);
    ResponseEntity<?> addStudent(AddStudentRequest addStudentRequest);
    ResponseEntity<?> deleteStudent(AddStudentRequest addStudentRequest);
    ResponseEntity<?> addTeacher(AddStudentRequest addStudentRequest);
    ResponseEntity<?> deleteTeacher(AddStudentRequest addStudentRequest);
    ResponseEntity<?> getAllTeacher(String nom);



}
