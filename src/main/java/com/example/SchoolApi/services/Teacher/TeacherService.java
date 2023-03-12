package com.example.SchoolApi.services.Teacher;

<<<<<<< HEAD

=======
import com.example.SchoolApi.models.Classe;
>>>>>>> 91343ac42a09f2f5135eb666d577ad8285239f40
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
<<<<<<< HEAD
            updated.setNom(updateTeacher.getNom());
            updated.setEmail_teacher(updateTeacher.getEmail_teacher());
            teacherRepo.save(updated);
=======
            updated.setNomTeacher(updateTeacher.getNomTeacher());
            updated.setEmailTeacher(updateTeacher.getEmailTeacher());
            updated.setMotDePasseTeacher(updateTeacher.getMotDePasseTeacher());
>>>>>>> 91343ac42a09f2f5135eb666d577ad8285239f40
            return ResponseEntity.ok(updated);
        }
        else
            return ResponseEntity.ok("teacher dosn't exist");
    }

    @Override
<<<<<<< HEAD
    public ResponseEntity<?> delete(Long idt) {

        Optional<Teacher> teacher=teacherRepo.findById(idt);
        if(teacher.isPresent()) {
            teacherRepo.deleteById(idt);
        }else{
            return ResponseEntity.ok("teacher not found");
        }
        return ResponseEntity.ok("teacher suprimer");
=======
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
>>>>>>> 91343ac42a09f2f5135eb666d577ad8285239f40
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
