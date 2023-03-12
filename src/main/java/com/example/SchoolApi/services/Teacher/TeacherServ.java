package com.example.SchoolApi.services.Teacher;

import com.example.SchoolApi.models.Teacher;
import org.springframework.http.ResponseEntity;

public interface TeacherServ {
    ResponseEntity<?> getAll();
    ResponseEntity<?> getById(Long id_teacher);
    ResponseEntity<?> add(Teacher teacher);
    ResponseEntity<?> update(Teacher teacher,Long id_teacher);
    ResponseEntity<?> delete(Long id_teacher);

    ResponseEntity<?> findByEmail(String email);
    ResponseEntity<?> findByNom(String nom);

}
