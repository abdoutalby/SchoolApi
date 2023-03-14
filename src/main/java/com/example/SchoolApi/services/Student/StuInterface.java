package com.example.SchoolApi.services.Student;

import com.example.SchoolApi.models.Student;
import com.example.SchoolApi.utils.AddStudentRequest;
import org.springframework.http.ResponseEntity;

public interface StuInterface {
    ResponseEntity<?> getAll();
    ResponseEntity<?> getById(Long id);
    ResponseEntity<?> add(Student addStudent);
    ResponseEntity<?> update(Student student,Long id);
    ResponseEntity<?> delete(Long id);
    ResponseEntity<?> findByName(String nom);
    ResponseEntity<?> getAllTeachers(Long idStudent);
    ResponseEntity<?> addTeacher(AddStudentRequest addStudentRequest);
    ResponseEntity<?> deleteTeacher(AddStudentRequest addStudentRequest);
}
