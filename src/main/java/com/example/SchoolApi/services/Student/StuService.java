package com.example.SchoolApi.services.Student;

import com.example.SchoolApi.models.Student;
import com.example.SchoolApi.repositories.StuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
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
        return ResponseEntity.ok(stuRepo.save(student));
    }

    @Override
    public ResponseEntity<?> update(Student upStudent, Long id) {
        Optional<Student> student=stuRepo.findById(id);
        if(student.isPresent()) {
            Student updated = student.get();
            updated.setAge(upStudent.getAge());
            updated.setName(upStudent.getName());
            updated.setUserClass(upStudent.getUserClass());
            stuRepo.save(updated);
            return ResponseEntity.ok(updated);
        }
        else
            return ResponseEntity.ok("student dosn't exist");
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        Optional<Student> student=stuRepo.findById(id);
        if(student.isPresent()) {
            stuRepo.deleteById(id);
            return ResponseEntity.ok("student deleted");
        }

        else
            return ResponseEntity.ok("student dosn't exist");
    }

    @Override
    public ResponseEntity<?> findByName(String nom) {
        Optional<Student> student=stuRepo.findByName(nom);
        if (student.isPresent())
            return ResponseEntity.ok(student.get());
        else
            return ResponseEntity.ok("student with name "+nom+" dosn't exist");
    }
}
