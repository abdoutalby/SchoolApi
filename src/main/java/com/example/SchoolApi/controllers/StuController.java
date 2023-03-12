package com.example.SchoolApi.controllers;


import com.example.SchoolApi.models.Student;
import com.example.SchoolApi.services.Student.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
 @RequestMapping("Student")
public class StuController {
    @Autowired
    StuService stuService;
    @GetMapping("/getAll")
    ResponseEntity<?> getAll(){
        return stuService.getAll();
    }

    @GetMapping("/getById/{id}")
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
}
