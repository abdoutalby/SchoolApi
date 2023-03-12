package com.example.SchoolApi.services.Teacher;

import com.example.SchoolApi.models.Student;
import com.example.SchoolApi.models.Teacher;
import com.example.SchoolApi.utils.AddStudentRequest;
import org.springframework.http.ResponseEntity;

public interface TeacherServ {
    ResponseEntity<?> getAll();
    ResponseEntity<?> getById(Long id_teacher);
    ResponseEntity<?> add(Teacher teacher);
    ResponseEntity<?> update(Teacher teacher,Long id_teacher);
    ResponseEntity<?> delete(Long id_teacher);

    ResponseEntity<?> findByEmail(String email);
    ResponseEntity<?> findByNom(String nom);
    ResponseEntity<?> addStudent(AddStudentRequest addStudentRequest);
    ResponseEntity<?> getAllStudent(Long idTeacher);
    ResponseEntity<?> deleteStudent(AddStudentRequest addStudentRequest);
    ResponseEntity<?> getAllClasses(Long idTeacher);

}
