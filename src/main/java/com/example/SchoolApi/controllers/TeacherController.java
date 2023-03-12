package com.example.SchoolApi.controllers;

import com.example.SchoolApi.models.Student;
import com.example.SchoolApi.models.Teacher;
import com.example.SchoolApi.services.Student.StuService;
import com.example.SchoolApi.services.Teacher.TeacherService;
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


}
