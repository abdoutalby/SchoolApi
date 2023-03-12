package com.example.SchoolApi.controllers;


import com.example.SchoolApi.models.Teacher;
import com.example.SchoolApi.services.Teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Teacher")
public class TeacherController {
    @Autowired
    TeacherService teacherService;
    @GetMapping("/getAll")
    ResponseEntity<?> getAll(){
        return teacherService.getAll();
    }

    @GetMapping("/getById/{id}")
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
}
