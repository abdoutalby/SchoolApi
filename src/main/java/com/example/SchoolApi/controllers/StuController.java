package com.example.SchoolApi.controllers;

import com.example.SchoolApi.models.Student;
import com.example.SchoolApi.services.Student.StuService;
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
    ResponseEntity<?> getAllProd(){
        return stuService.getAll();
    }

    @GetMapping("/getById/{id}")
    ResponseEntity<?> getByIdProd(@PathVariable("id") Long id){return stuService.getById(id);}

    @PostMapping("/add")
    ResponseEntity<?> addProd(@Valid @RequestBody Student student){return stuService.add(student);}

    @PatchMapping("update/{id}")
    ResponseEntity<?> updateProd(@RequestBody Student student,@PathVariable("id") Long id){return stuService.update(student,id);}

    @DeleteMapping("delete/{id}")
    ResponseEntity<?> deleteProd(@PathVariable("id") Long id){
        return stuService.delete(id);
    }

    @GetMapping("getByName/{nom}")
    ResponseEntity<?> getByName(@PathVariable("nom") String nom){return stuService.findByName(nom);}
}
