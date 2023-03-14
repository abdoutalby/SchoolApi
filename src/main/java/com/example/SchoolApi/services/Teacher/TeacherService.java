package com.example.SchoolApi.services.Teacher;

import com.example.SchoolApi.models.Classe;
import com.example.SchoolApi.models.Student;
import com.example.SchoolApi.models.Teacher;
import com.example.SchoolApi.repositories.StuRepo;
import com.example.SchoolApi.repositories.TeacherRepo;
import com.example.SchoolApi.repositories.claRepo;
import com.example.SchoolApi.utils.AddStudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherService implements TeacherServ {

    @Autowired
    private TeacherRepo teacherRepo;

    @Autowired
    private StuRepo stuRepo;
    @Autowired
    claRepo claRepo;

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

    @Override
    public ResponseEntity<?> addStudent(AddStudentRequest addStudentRequest) {
            Optional<Teacher> teacher=teacherRepo.findById(addStudentRequest.getIdTeacher());
            Optional<Student> student=stuRepo.findById(addStudentRequest.getIdStudent());
            if (teacher.isPresent()){
                if (student.isPresent()){
                    Teacher teacher1=teacher.get();
                    List<Student> students=teacher1.getStudents();
                    student.get().getTeachers().add(teacher1);
                    students.add(student.get());
                    teacher1.setStudents(students);
                    teacherRepo.save(teacher1);
                   return ResponseEntity.ok(teacher1);

                }
                else {
                    return ResponseEntity.ok("student not found");
                }

            }
            else {
                return ResponseEntity.ok("teacher not found");
            }


    }

    @Override
    public ResponseEntity<?> getAllStudent(Long idTeacher) {
        Optional<Teacher> teacher=teacherRepo.findById(idTeacher);
        if(teacher.isPresent()){
            return ResponseEntity.ok(teacher.get().getStudents());
        }
        else
            return ResponseEntity.ok("teacher not found");
    }

    @Override
    public ResponseEntity<?> deleteStudent(AddStudentRequest addStudentRequest) {
        Optional<Teacher> teacher=teacherRepo.findById(addStudentRequest.getIdTeacher());
        Optional<Student> student=stuRepo.findById(addStudentRequest.getIdStudent());
        if (teacher.isPresent()){
            if (student.isPresent()){
                Teacher teacher1=teacher.get();
                student.get().getTeachers().remove(teacher1);
                teacher1.getStudents().remove(student.get());
                teacherRepo.save(teacher1);
                return ResponseEntity.ok(teacher1);

            }
            else {
                return ResponseEntity.ok("student not found");
            }

        }
        else {
            return ResponseEntity.ok("teacher not found");
        }
    }

    @Override
    public ResponseEntity<?> getAllClasses(Long idTeacher) {
        Optional<Teacher> teacher=teacherRepo.findById(idTeacher);
        if(teacher.isPresent()){
            return ResponseEntity.ok(teacher.get().getClasses());
        }
        else
            return ResponseEntity.ok("teacher not found");
    }

    @Override
    public ResponseEntity<?> addClasse(AddStudentRequest addStudentRequest) {
        Optional<Teacher> teacher=teacherRepo.findById(addStudentRequest.getIdTeacher());
        Optional<Classe> classe=claRepo.findById(addStudentRequest.getIdClass());
        if (teacher.isPresent()) {
            if (classe.isPresent()) {
                Teacher teacher1 = teacher.get();
                List<Classe> classes = teacher1.getClasses();
                classe.get().getTeachers().add(teacher1);
                classes.add(classe.get());
                teacher1.setClasses(classes);
                teacherRepo.save(teacher1);
                return ResponseEntity.ok(teacher1);

            } else
                return ResponseEntity.ok("classe not found");


        }
        else
            return ResponseEntity.ok("teacher not found");


    }

    @Override
    public ResponseEntity<?> deleteClasse(AddStudentRequest addStudentRequest) {
        Optional<Teacher> teacher=teacherRepo.findById(addStudentRequest.getIdTeacher());
        Optional<Classe> classe=claRepo.findById(addStudentRequest.getIdClass());
        if (teacher.isPresent()){
            if (classe.isPresent()){
                Teacher teacher1=teacher.get();
                classe.get().getTeachers().remove(teacher1);
                teacher1.getClasses().remove(classe.get());
                teacherRepo.save(teacher1);
                return ResponseEntity.ok(teacher1);

            }
            else {
                return ResponseEntity.ok("classe not found");
            }

        }
        else {
            return ResponseEntity.ok("teacher not found");
        }

    }


}
