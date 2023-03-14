package com.example.SchoolApi.services.ClasseService;

import com.example.SchoolApi.models.Classe;
import com.example.SchoolApi.models.Student;
import com.example.SchoolApi.models.Teacher;
import com.example.SchoolApi.repositories.StuRepo;
import com.example.SchoolApi.repositories.TeacherRepo;
import com.example.SchoolApi.repositories.claRepo;
import com.example.SchoolApi.utils.AddStudentRequest;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class claServ implements claService {
@Autowired
public claRepo claRepo;
@Autowired
    StuRepo stuRepo;
@Autowired
    TeacherRepo teacherRepo;
    @Override
    public ResponseEntity<?> getAll() {
        List<Classe> classes=new ArrayList<>();
        classes=claRepo.findAll();
       //log.info("classe in the service :{} ",classes);
        return ResponseEntity.ok(classes);
    }

    @Override
    public ResponseEntity<?> getById(Long id) {
        Optional<Classe> classe=claRepo.findById(id);
        if(classe.isPresent()){
         return ResponseEntity.ok(classe.get());
        }else {
            return ResponseEntity.ok("classe not found");
        }
    }

    @Override
    public ResponseEntity<?> create(Classe classe) {
        if (claRepo.existsByNomClass(classe.getNomClass()))
            return ResponseEntity.ok("classe exist");
        else
        return ResponseEntity.ok(claRepo.save(classe));
    }

    @Override
    public ResponseEntity<?> update(Classe upclasse, Long id) {
        Optional<Classe> classe=claRepo.findById(id);
        if(classe.isPresent()){
            Classe updated=classe.get();
            updated.setNomClass(upclasse.getNomClass());
            updated.setNiveauClass(upclasse.getNiveauClass());
            claRepo.save(updated);
            return ResponseEntity.ok(updated);
        }else{
            return ResponseEntity.ok("classe not found");
        }
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        Optional<Classe> classe=claRepo.findById(id);
        if(classe.isPresent()) {
            claRepo.deleteById(id);
            return ResponseEntity.ok("classe suprimer");
        }else{
            return ResponseEntity.ok("classe not found");
        }

    }

    @Override
    public ResponseEntity<?> findByNiveau(String niveau) {
        List<Classe> classe=claRepo.findByNiveauClass(niveau);
        if(classe.size()>0){
            return ResponseEntity.ok(classe);
        }else {
            return ResponseEntity.ok("classe not found");
        }
    }

    @Override
    public ResponseEntity<?> findByNom(String nom) {
        Optional<Classe> classe=claRepo.findByNomClass(nom);
        if(classe.isPresent()){
            return ResponseEntity.ok(classe);
        }else {
            return ResponseEntity.ok("classe not found");
        }
    }

    @Override
    public ResponseEntity<?> getAllStudent(String nom) {
       Optional<Classe> classe=claRepo.findByNomClass(nom);
       if(classe.isPresent()){
           return ResponseEntity.ok(classe.get().getStudents());
       }
       else
           return ResponseEntity.ok("classe not found");
    }

    @Override
    public ResponseEntity<?> addStudent(AddStudentRequest addStudentRequest) {
        Optional<Classe> classe=claRepo.findById(addStudentRequest.getIdClass());
        Optional<Student> student=stuRepo.findById(addStudentRequest.getIdStudent());
        if (classe.isPresent()){
            if (student.isPresent()){
                Classe classe1=classe.get();
                student.get().setUserClass(classe.get());
                classe1.getStudents().add(student.get());
                claRepo.save(classe1);
                log.info(classe1.getStudents().get(1).getNameStu());

                return ResponseEntity.ok(classe.get());

            }
            else {
                return ResponseEntity.ok("student not found");
            }

        }
        else {
            return ResponseEntity.ok("classe not found");
        }
    }

    @Override
    public ResponseEntity<?> deleteStudent(AddStudentRequest addStudentRequest) {
        Optional<Classe> classe=claRepo.findById(addStudentRequest.getIdClass());
        Optional<Student> student=stuRepo.findById(addStudentRequest.getIdStudent());
        if (classe.isPresent()){
            if (student.isPresent()){
                Classe classe1=classe.get();
                student.get().setUserClass(null);
                claRepo.save(classe1);
                return ResponseEntity.ok(classe1);

            }
            else {
                return ResponseEntity.ok("student not found");
            }

        }
        else {
            return ResponseEntity.ok("class not found");
        }
    }

    @Override
    public ResponseEntity<?> addTeacher(AddStudentRequest addStudentRequest) {
        Optional<Classe> classe=claRepo.findById(addStudentRequest.getIdClass());
        Optional<Teacher> teacher=teacherRepo.findById(addStudentRequest.getIdTeacher());
        if (classe.isPresent()){
            if (teacher.isPresent()){
                Classe classe1=classe.get();
                List<Teacher> teachers=classe1.getTeachers();


                teachers.add(teacher.get());
                log.info(classe.get().getTeachers().get(0).getNomTeacher());
                claRepo.save(classe1);
                return ResponseEntity.ok(classe1);

            }
            else {
                return ResponseEntity.ok("teacher not found");
            }

        }
        else {
            return ResponseEntity.ok("class not found");
        }
    }

    @Override
    public ResponseEntity<?> deleteTeacher(AddStudentRequest addStudentRequest) {
        Optional<Classe> classe=claRepo.findById(addStudentRequest.getIdClass());
        Optional<Teacher> teacher=teacherRepo.findById(addStudentRequest.getIdTeacher());
        if (classe.isPresent()){
            if (teacher.isPresent()){
                Classe classe1=classe.get();
                classe1.getTeachers().remove(teacher.get());
                claRepo.save(classe1);
                return ResponseEntity.ok(classe1);

            }
            else {
                return ResponseEntity.ok("teacher not found");
            }

        }
        else {
            return ResponseEntity.ok("class not found");
        }
    }

    @Override
    public ResponseEntity<?> getAllTeacher(String nom) {
       Optional<Classe> classe=claRepo.findByNomClass(nom);
       if (classe.isPresent())
           return ResponseEntity.ok(classe.get().getTeachers());

       else
           return ResponseEntity.ok("classe not found");
    }
}
