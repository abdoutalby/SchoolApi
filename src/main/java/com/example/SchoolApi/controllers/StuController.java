package com.example.SchoolApi.controllers;

<<<<<<< HEAD

import com.example.SchoolApi.models.Student;
import com.example.SchoolApi.services.Student.StuService;
=======
import com.example.SchoolApi.models.Student;
import com.example.SchoolApi.services.Student.StuService;
import jakarta.validation.Valid;
>>>>>>> 91343ac42a09f2f5135eb666d577ad8285239f40
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
<<<<<<< HEAD
 @RequestMapping("Student")
=======
@RequestMapping("Student")
>>>>>>> 91343ac42a09f2f5135eb666d577ad8285239f40
public class StuController {
    @Autowired
    StuService stuService;
    @GetMapping("/getAll")
<<<<<<< HEAD
    ResponseEntity<?> getAll(){
=======
    ResponseEntity<?> getAllStu(){
>>>>>>> 91343ac42a09f2f5135eb666d577ad8285239f40
        return stuService.getAll();
    }

    @GetMapping("/getById/{id}")
<<<<<<< HEAD
    ResponseEntity<?> getById(@PathVariable("id") Long id){return stuService.getById(id);}

    @PostMapping("/add")
    ResponseEntity<?> add(@RequestBody Student student){return stuService.add(student);}

    @PutMapping("/update/{id}")
    ResponseEntity<?> update(@RequestBody Student student,@PathVariable("id") Long id){return stuService.update(student,id);}

    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> delete(@PathVariable("id") Long id){
        return stuService.delete(id);
    }
    @GetMapping("/getByNom/{nom}")
    ResponseEntity<?> getByName(@PathVariable("nom") String name){return stuService.findByName(name);}
=======
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
>>>>>>> 91343ac42a09f2f5135eb666d577ad8285239f40
}
