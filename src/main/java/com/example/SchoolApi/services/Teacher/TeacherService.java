package com.example.SchoolApi.services.Teacher;

import com.example.SchoolApi.models.Classe;
import com.example.SchoolApi.models.Student;
import com.example.SchoolApi.models.Teacher;
import com.example.SchoolApi.repositories.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
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
            updated.setNomTeacher(updateTeacher.getNomTeacher());
            updated.setEmailTeacher(updateTeacher.getEmailTeacher());
            updated.setMotDePasseTeacher(updateTeacher.getMotDePasseTeacher());
            return ResponseEntity.ok(updated);
        }
        else
            return ResponseEntity.ok("teacher dosn't exist");
    }

    @Override
    public ResponseEntity<?> delete(Long id_teacher) {
        Optional<Teacher> teacher=teacherRepo.findById(id_teacher);
        if(teacher.isPresent()) {
            teacherRepo.deleteById(id_teacher);
            return ResponseEntity.ok("teacher "+teacher.get().getNomTeacher()+" deleted");
        }

        else
            return ResponseEntity.ok("teacher dosn't exist");
    }

    @Override
    public ResponseEntity<?> findByEmail(String email) {
        Optional<Teacher> teacher=teacherRepo.findByEmailTeacher(email);
        if(teacher.isPresent()){
            return ResponseEntity.ok(teacher.get());
        }else {
            return ResponseEntity.ok("teacher not found");
        }
    }

    @Override
    public ResponseEntity<?> findByNom(String nom) {
        List<Teacher> teacher=teacherRepo.findByNomTeacher(nom);
        if(teacher.size()>0){
            return ResponseEntity.ok(teacher);
        }else {
            return ResponseEntity.ok("teacher not found");
        }
    }
}
