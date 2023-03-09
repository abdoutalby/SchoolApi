package com.example.SchoolApi.services.Student;

import com.example.SchoolApi.models.Student;
import com.example.SchoolApi.repositories.StuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StuService implements StuInterface{

    @Autowired
    StuRepo stuRepo;
    @Override
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(stuRepo.findAll());
    }

    @Override
    public ResponseEntity<?> getById(Long id) {
        Optional<Student> student=stuRepo.findById(id);
        if(student.isPresent())
            return ResponseEntity.ok(student.get());
        else
            return ResponseEntity.ok("student dosn't exist");
    }

    @Override
    public ResponseEntity<?> add(Student student) {
        return null;
    }

    @Override
    public ResponseEntity<?> update(Student student, Long id) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<?> findByNomProd(String nom) {
        return null;
    }
}
