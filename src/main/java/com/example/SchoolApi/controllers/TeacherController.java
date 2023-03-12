package com.example.SchoolApi.controllers;

<<<<<<< HEAD

import com.example.SchoolApi.models.Teacher;
import com.example.SchoolApi.services.Teacher.TeacherService;
=======
import com.example.SchoolApi.models.Student;
import com.example.SchoolApi.models.Teacher;
import com.example.SchoolApi.services.Student.StuService;
import com.example.SchoolApi.services.Teacher.TeacherService;
import jakarta.validation.Valid;
>>>>>>> 91343ac42a09f2f5135eb666d577ad8285239f40
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Teacher")
public class TeacherController {
    @Autowired
    TeacherService teacherService;
    @GetMapping("/getAll")
<<<<<<< HEAD
    ResponseEntity<?> getAll(){
=======
    ResponseEntity<?> getAllTeacher(){
>>>>>>> 91343ac42a09f2f5135eb666d577ad8285239f40
        return teacherService.getAll();
    }

    @GetMapping("/getById/{id}")
<<<<<<< HEAD
    ResponseEntity<?> getById(@PathVariable("id") Long id){return teacherService.getById(id);}

    @PostMapping("/add")
    ResponseEntity<?> add(@RequestBody Teacher teacher){return teacherService.add(teacher);}

    @PutMapping("/update/{id}")
    ResponseEntity<?> update(@RequestBody Teacher teacher,@PathVariable("id") Long id){return teacherService.update(teacher,id);}

    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> delete(@PathVariable("id") Long id){
        return teacherService.delete(id);
    }
    @GetMapping("/getByNom/{nom}")
    ResponseEntity<?> getByNom(@PathVariable("nom") String nom){return teacherService.findByNom(nom);}
=======
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


>>>>>>> 91343ac42a09f2f5135eb666d577ad8285239f40
}
