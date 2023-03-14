package com.example.SchoolApi.controllers;

import com.example.SchoolApi.models.Student;
import com.example.SchoolApi.services.Student.StuService;
import com.example.SchoolApi.utils.AddStudentRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Student")
public class StuController {
    @Autowired
    StuService stuService;
    @GetMapping("/getAll")
    ResponseEntity<?> getAllStu(){
        return stuService.getAll();
    }

    @GetMapping("/getById/{id}")
    ResponseEntity<?> getByIdStu(@PathVariable("id") Long id){return stuService.getById(id);}

    @PostMapping("/add")
    ResponseEntity<?> addStu(@Valid @RequestBody Student student){
        return stuService.add(student);}

    @PatchMapping("update/{id}")
    ResponseEntity<?> updateStu(@RequestBody Student student,@PathVariable("id") Long id){return stuService.update(student,id);}

    @DeleteMapping("delete/{id}")
    ResponseEntity<?> deleteStu(@PathVariable("id") Long id){
        return stuService.delete(id);
    }

    @GetMapping("getByName/{nom}")
    ResponseEntity<?> getByName(@PathVariable("nom") String nom){return stuService.findByName(nom);}

    @GetMapping("getAllTeachers/{idSt}")
    ResponseEntity<?> getAllTeacher(@PathVariable("idSt") Long idSt){return stuService.getAllTeachers(idSt);}

    @PatchMapping("/addTeacher")
    ResponseEntity<?> addTeacher(@RequestBody AddStudentRequest addStudentRequest){return stuService.addTeacher(addStudentRequest);}

    @PatchMapping("deleteTeacher")
    ResponseEntity<?> deleteTeacher(@RequestBody AddStudentRequest addStudentRequest){return stuService.deleteTeacher(addStudentRequest);}



}
