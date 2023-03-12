package com.example.SchoolApi.services.Teacher;

import com.example.SchoolApi.models.Student;
import com.example.SchoolApi.models.Teacher;
import org.springframework.http.ResponseEntity;

public interface TeacherServ {
    ResponseEntity<?> getAll();
    ResponseEntity<?> getById(Long id);
    ResponseEntity<?> add(Teacher teacher);
    ResponseEntity<?> update(Teacher teacher,Long id);
    ResponseEntity<?> delete(Long id);
    ResponseEntity<?> findByNom(String Nom);
    ResponseEntity<?> addStu (Student id,Long idt);

    ResponseEntity<?> findByEmail(String email);
    ResponseEntity<?> findByNom(String nom);

}
