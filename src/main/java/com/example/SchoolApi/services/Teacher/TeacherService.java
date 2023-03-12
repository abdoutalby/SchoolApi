package com.example.SchoolApi.services.Teacher;


import com.example.SchoolApi.models.Student;
import com.example.SchoolApi.models.Teacher;
import com.example.SchoolApi.repositories.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeacherService implements TeacherServ {

    @Autowired
    private TeacherRepo teacherRepo;

    @Override
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(teacherRepo.findAll());
    }

    @Override
    public ResponseEntity<?> getById(Long idt) {
        Optional<Teacher> teacher=teacherRepo.findById(idt);
        if(teacher.isPresent())
            return ResponseEntity.ok(teacher.get());
        else
            return ResponseEntity.ok("Teacher dosn't exist");
    }

    @Override
    public ResponseEntity<?> add(Teacher teacher) {
        return ResponseEntity.ok(teacherRepo.save(teacher));
    }

    @Override
    public ResponseEntity<?> update(Teacher updateTeacher, Long idt) {
        Optional<Teacher> teacher=teacherRepo.findById(idt);
        if(teacher.isPresent()){
            Teacher updated =teacher.get();
            updated.setNom(updateTeacher.getNom());
            updated.setEmail_teacher(updateTeacher.getEmail_teacher());
            teacherRepo.save(updated);
            return ResponseEntity.ok(updated);
        }
        else
            return ResponseEntity.ok("teacher dosn't exist");
    }

    @Override
    public ResponseEntity<?> delete(Long idt) {

        Optional<Teacher> teacher=teacherRepo.findById(idt);
        if(teacher.isPresent()) {
            teacherRepo.deleteById(idt);
        }else{
            return ResponseEntity.ok("teacher not found");
        }
        return ResponseEntity.ok("teacher suprimer");
    }
    @Override
    public ResponseEntity<?> findByNom(String nom) {
        Optional<Teacher> teacher=teacherRepo.findByNom(nom);
        if(teacher.isPresent()){
            return ResponseEntity.ok(teacher.get());
        }else {
            return ResponseEntity.ok("teacher not found");
        }
    }

    @Override
    public ResponseEntity<?> addStu(Student id, Long idt) {
        Optional<Teacher> teacher=teacherRepo.findById(idt);

    }


}
