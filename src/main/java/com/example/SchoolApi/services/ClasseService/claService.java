package com.example.SchoolApi.services.ClasseService;

import com.example.SchoolApi.models.Classe;
import org.springframework.http.ResponseEntity;

public interface claService {
    ResponseEntity<?> getAll();
    ResponseEntity<?> getById(Long id);
    ResponseEntity<?> create(Classe classe);
    ResponseEntity<?> update(Classe classe, Long id);
    ResponseEntity<?> delete(Long id);
    ResponseEntity<?> findByNiveau(String niveau);
    ResponseEntity<?> findByNom(String nom);
    ResponseEntity<?> getAllStudent(String nom);
}
