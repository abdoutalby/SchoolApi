package com.example.SchoolApi.services.Teacher;

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
    public ResponseEntity<?> getById(Long id_teacher) {
        Optional<Teacher> teacher=teacherRepo.findById(id_teacher);
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
    public ResponseEntity<?> update(Teacher updateTeacher, Long id_teacher) {
        Optional<Teacher> teacher=teacherRepo.findById(id_teacher);
        if(teacher.isPresent()){
            Teacher updated =teacher.get();
            updated.setNom_teacher(updateTeacher.getNom_teacher());
            updated.setEmail_teacher(updateTeacher.getEmail_teacher());

            return ResponseEntity.ok(updated);
        }
        else
            return ResponseEntity.ok("Fournisseur dosn't exist");
    }

    @Override
    public ResponseEntity<?> delete(Long id_teacher) {
        return null;
    }
}
