package com.example.SchoolApi.controllers;

import com.example.SchoolApi.models.Classe;
import com.example.SchoolApi.models.Teacher;
import com.example.SchoolApi.services.ClasseService.claServ;
import com.example.SchoolApi.utils.AddStudentRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Classe")
public class claController {
@Autowired
claServ calServ;
    @GetMapping("/getAll")
    ResponseEntity<?> getAllClass(){
        return calServ.getAll();
    }

    @GetMapping("/getById/{id}")
    ResponseEntity<?> getByIdClass(@PathVariable("id") Long id){return calServ.getById(id);}

    @PostMapping("/add")
    ResponseEntity<?> addClass(@Valid @RequestBody Classe classe){return calServ.create(classe);}

    @PatchMapping("update/{id}")
    ResponseEntity<?> updateClass(@RequestBody Classe classe, @PathVariable("id") Long id){return calServ.update(classe,id);}

    @DeleteMapping("delete/{id}")
    ResponseEntity<?> deleteClass(@PathVariable("id") Long id){
        return calServ.delete(id);
    }

    @GetMapping("/getByNiveau/{niveau}")
    ResponseEntity<?> getByNiveauClasse(@PathVariable("niveau") String niveau){return calServ.findByNiveau(niveau);}

    @GetMapping("/getByNom/{nom}")
    ResponseEntity<?> getByNom(@PathVariable("nom") String nom){return calServ.findByNom(nom);}

    @GetMapping("/getAllStudent/{nom}")
    ResponseEntity<?> getAllStudent(@PathVariable("nom") String nom){return calServ.getAllStudent(nom);}

    @PatchMapping("/addStudent")
    ResponseEntity<?> addStudent(@RequestBody AddStudentRequest addStudentRequest){return calServ.addStudent(addStudentRequest);}

    @PatchMapping("deleteStudent")
    ResponseEntity<?> deleteStudent(@RequestBody AddStudentRequest addStudentRequest){return calServ.deleteStudent(addStudentRequest);}

    @PatchMapping("/addTeacher")
    ResponseEntity<?> addTeacher(@RequestBody AddStudentRequest addStudentRequest){return calServ.addTeacher(addStudentRequest);}

    @PatchMapping("deleteTeacher")
    ResponseEntity<?> deleteTeacher(@RequestBody AddStudentRequest addStudentRequest){return calServ.deleteTeacher(addStudentRequest);}

    @GetMapping("/getAllTeacher/{nom}")
    ResponseEntity<?> getAllTeacher(@PathVariable("nom") String nom){return calServ.getAllTeacher(nom);}


}
