package com.example.SchoolApi.services.ClasseService;

import com.example.SchoolApi.models.Class;
import com.example.SchoolApi.repositories.claRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class claServ implements claService {
@Autowired
private claRepo claRepo;

    @Override
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(claRepo.findAll());
    }

    @Override
    public ResponseEntity<?> getById(Long id) {
        Optional<Class> classe=claRepo.findById(id);
        if(classe.isPresent()){
         return ResponseEntity.ok(classe.get());
        }else {
            return ResponseEntity.ok("classe not found");
        }
    }

    @Override
    public ResponseEntity<?> add(Class classe) {
        return ResponseEntity.ok(claRepo.save(classe));
    }

    @Override
    public ResponseEntity<?> update(Class upclasse, Long id) {
        Optional<Class> classe=claRepo.findById(id);
        if(classe.isPresent()){
            Class updated=classe.get();
            updated.setNom(upclasse.getNom());
            updated.setNiveau(upclasse.getNiveau());
            claRepo.save(updated);
            return ResponseEntity.ok(updated);
        }else{
            return ResponseEntity.ok("classe not found");
        }
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        Optional<Class> classe=claRepo.findById(id);
        if(classe.isPresent()) {
            claRepo.deleteById(id);
        }else{
            return ResponseEntity.ok("classe not found");
        }
        return ResponseEntity.ok("classe suprimer");
    }

    @Override
    public ResponseEntity<?> findByNom(String Nom) {
        Optional<Class> classe=claRepo.findByNom(Nom);
        if(classe.isPresent()){
            return ResponseEntity.ok(classe.get());
        }else {
            return ResponseEntity.ok("classe not found");
        }
    }


}
