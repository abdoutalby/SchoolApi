package com.example.SchoolApi.services.Student;

import com.example.SchoolApi.models.Student;
import com.example.SchoolApi.repositories.StuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
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
        if(student.isPresent()) {
            return ResponseEntity.ok(student.get());
        }
        else {
            return ResponseEntity.ok("student dosn't found");
        }
    }

    @Override
    public ResponseEntity<?> add(Student addStudent) {

            return ResponseEntity.ok(stuRepo.save(addStudent));


    }

    @Override
    public ResponseEntity<?> update(Student upStudent, Long id) {
        Optional<Student> student=stuRepo.findById(id);
        if(student.isPresent()) {
            Student updated = student.get();
            updated.setAgeStu(upStudent.getAgeStu());
            updated.setNameStu(upStudent.getNameStu());
            updated.setUserClass(upStudent.getUserClass());
            stuRepo.save(updated);
            return ResponseEntity.ok(updated);
        }
        else
            return ResponseEntity.ok("student dosn't found");
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        Optional<Student> student=stuRepo.findById(id);
        if(student.isPresent()) {
            stuRepo.deleteById(id);
            return ResponseEntity.ok("student "+student.get().getNameStu()+" deleted");
        }else{
            return ResponseEntity.ok("student dosn't found");
        }
    }

    @Override
    public ResponseEntity<?> findByName(String nom) {
        List<Student> student=stuRepo.findByNameStu(nom);
        if (student.size()>0)
            return ResponseEntity.ok(student);
        else
            return ResponseEntity.ok("student with name "+nom+" dosn't found");
    }

    @Override
    public ResponseEntity<?> getAllTeachers(Long idStudent) {
        Optional<Student> student=stuRepo.findById(idStudent);
        if (student.isPresent()){
            Student student1=student.get();
           return ResponseEntity.ok(student1.getTeachers());

        }
        else
            return ResponseEntity.ok("student not found");
    }
}
