package com.example.SchoolApi.services.Student;

import com.example.SchoolApi.models.Class;
import com.example.SchoolApi.models.Student;
import com.example.SchoolApi.models.Teacher;
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
<<<<<<< HEAD
            return ResponseEntity.ok("student dosn't exist");
    }

    @Override
    public ResponseEntity<?> add(Student student) {
        return ResponseEntity.ok(stuRepo.save(student));
    }

    @Override
    public ResponseEntity<?> update(Student upstudent, Long id) {
        Optional<Student> student=stuRepo.findById(id);
        if(student.isPresent()){
            Student updated =student.get();
            updated.setName(upstudent.getName());
            updated.setAge(upstudent.getAge());
            stuRepo.save(updated);
            return ResponseEntity.ok(updated);
        }
        else
            return ResponseEntity.ok("student dosn't exist");

=======
            return ResponseEntity.ok("student dosn't found");
>>>>>>> 91343ac42a09f2f5135eb666d577ad8285239f40
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        Optional<Student> student=stuRepo.findById(id);
        if(student.isPresent()) {
            stuRepo.deleteById(id);
<<<<<<< HEAD
        }else{
            return ResponseEntity.ok("student not found");
        }
        return ResponseEntity.ok("student suprimer");
    }

    @Override
    public ResponseEntity<?> findByName(String name) {
        Optional<Student> student=stuRepo.findByName(name);
        if(student.isPresent()){
            return ResponseEntity.ok(student.get());
        }else {
            return ResponseEntity.ok("student not found");
        }
=======
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
>>>>>>> 91343ac42a09f2f5135eb666d577ad8285239f40
    }
}
