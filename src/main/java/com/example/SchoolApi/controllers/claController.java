package com.example.SchoolApi.controllers;
<<<<<<< HEAD
import com.example.SchoolApi.models.Class;
=======

import com.example.SchoolApi.models.Classe;
import com.example.SchoolApi.models.Teacher;
>>>>>>> 91343ac42a09f2f5135eb666d577ad8285239f40
import com.example.SchoolApi.services.ClasseService.claServ;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Class")
public class claController {
@Autowired
<<<<<<< HEAD
claServ claServ;
    @GetMapping("/getAll")
    ResponseEntity<?> getAll(){
        return claServ.getAll();
    }

    @GetMapping("/getById/{id}")
    ResponseEntity<?> getById(@PathVariable("id") Long id){return claServ.getById(id);}

    @PostMapping("/add")
    ResponseEntity<?> add(@RequestBody Class classe){return claServ.add(classe);}

    @PutMapping("/update/{id}")
    ResponseEntity<?> update(@RequestBody Class classe,@PathVariable("id") Long id){return claServ.update(classe,id);}

    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> delete(@PathVariable("id") Long id){
        return claServ.delete(id);
    }
    @GetMapping("/getByNom/{nom}")
    ResponseEntity<?> getByNom(@PathVariable("nom") String Nom){return claServ.findByNom(Nom);}
=======
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


>>>>>>> 91343ac42a09f2f5135eb666d577ad8285239f40
}
