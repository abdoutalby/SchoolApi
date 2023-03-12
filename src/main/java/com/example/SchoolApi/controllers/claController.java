package com.example.SchoolApi.controllers;
import com.example.SchoolApi.models.Class;
import com.example.SchoolApi.services.ClasseService.claServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Class")
public class claController {
@Autowired
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
}
