package com.example.SchoolApi.controllers;

import com.example.SchoolApi.models.Student;
import com.example.SchoolApi.models.Teacher;
import com.example.SchoolApi.services.Student.StuService;
import com.example.SchoolApi.services.Teacher.TeacherService;
import com.example.SchoolApi.utils.AddStudentRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Teacher")
public class TeacherController {
    @Autowired
    TeacherService teacherService;
    @GetMapping("/getAll")
    ResponseEntity<?> getAllTeacher(){
        return teacherService.getAll();
    }

    @GetMapping("/getById/{id}")
    ResponseEntity<?> getByIdTeacher(@PathVariable("id") Long id){return teacherService.getById(id);}

    @PostMapping("/add")
    ResponseEntity<?> addTeacher(@Valid @RequestBody Teacher teacher){return teacherService.add(teacher);}

    @PatchMapping("update/{id}")
    ResponseEntity<?> updateTeacher(@RequestBody Teacher teacher,@PathVariable("id") Long id){return teacherService.update(teacher,id);}

    @DeleteMapping("delete/{id}")
    ResponseEntity<?> deleteTeacher(@PathVariable("id") Long id){
        return teacherService.delete(id);
    }

    @GetMapping("/getByEmail/{email}")
    ResponseEntity<?> getByEmail(@PathVariable("email") String email){return teacherService.findByEmail(email);}

    @GetMapping("/getByNom/{nom}")
    ResponseEntity<?> getByNom(@PathVariable("nom") String nom){return teacherService.findByNom(nom);}

    @PatchMapping("addStudent")
    ResponseEntity<?> addStudent(@RequestBody AddStudentRequest addStudentRequest){return teacherService.addStudent(addStudentRequest);}

    @GetMapping("/getAllStudent/{idTeacher}")
    ResponseEntity<?> getAllStudent(@PathVariable("idTeacher") Long id){return teacherService.getAllStudent(id);}

    @PatchMapping("deleteStudent")
    ResponseEntity<?> deleteStudent(@RequestBody AddStudentRequest addStudentRequest){return teacherService.deleteStudent(addStudentRequest);}

    @GetMapping("/getAllClasses/{idTeacher}")
    ResponseEntity<?> getAllClasses(@PathVariable("idTeacher") Long id){return teacherService.getAllClasses(id);}

    @PatchMapping("/addClasse")
    ResponseEntity<?> addClasse(@RequestBody AddStudentRequest addStudentRequest){return teacherService.addClasse(addStudentRequest);}

    @PatchMapping("deleteClasse")
    ResponseEntity<?> deleteClasse(@RequestBody AddStudentRequest addStudentRequest){return teacherService.deleteClasse(addStudentRequest);}


}
