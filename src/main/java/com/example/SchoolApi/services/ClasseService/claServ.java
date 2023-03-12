package com.example.SchoolApi.services.ClasseService;

import com.example.SchoolApi.models.Classe;
import com.example.SchoolApi.repositories.claRepo;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class claServ implements claService {
@Autowired
public claRepo claRepo;
    @Override
    public ResponseEntity<?> getAll() {
        List<Classe> classes=new ArrayList<>();
        classes=claRepo.findAll();
       //log.info("classe in the service :{} ",classes);
        return ResponseEntity.ok(classes);
    }

    @Override
    public ResponseEntity<?> getById(Long id) {
        Optional<Classe> classe=claRepo.findById(id);
        if(classe.isPresent()){
         return ResponseEntity.ok(classe.get());
        }else {
            return ResponseEntity.ok("classe not found");
        }
    }

    @Override
    public ResponseEntity<?> create(Classe classe) {
        if (claRepo.existsByNomClass(classe.getNomClass()))
            return ResponseEntity.ok("classe exist");
        else
        return ResponseEntity.ok(claRepo.save(classe));
    }

    @Override
    public ResponseEntity<?> update(Classe upclasse, Long id) {
        Optional<Classe> classe=claRepo.findById(id);
        if(classe.isPresent()){
            Classe updated=classe.get();
            updated.setNomClass(upclasse.getNomClass());
            updated.setNiveauClass(upclasse.getNiveauClass());
            claRepo.save(updated);
            return ResponseEntity.ok(updated);
        }else{
            return ResponseEntity.ok("classe not found");
        }
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        Optional<Classe> classe=claRepo.findById(id);
        if(classe.isPresent()) {
            claRepo.deleteById(id);
            return ResponseEntity.ok("classe suprimer");
        }else{
            return ResponseEntity.ok("classe not found");
        }

    }

    @Override
    public ResponseEntity<?> findByNiveau(String niveau) {
        List<Classe> classe=claRepo.findByNiveauClass(niveau);
        if(classe.size()>0){
            return ResponseEntity.ok(classe);
        }else {
            return ResponseEntity.ok("classe not found");
        }
    }

    @Override
    public ResponseEntity<?> findByNom(String nom) {
        Optional<Classe> classe=claRepo.findByNomClass(nom);
        if(classe.isPresent()){
            return ResponseEntity.ok(classe);
        }else {
            return ResponseEntity.ok("classe not found");
        }
    }

    @Override
    public ResponseEntity<?> getAllStudent(String nom) {
       Optional<Classe> classe=claRepo.findByNomClass(nom);
       if(classe.isPresent()){
           return ResponseEntity.ok(classe.get().getStudents());
       }
       else
           return ResponseEntity.ok("classe not found");
    }
}
