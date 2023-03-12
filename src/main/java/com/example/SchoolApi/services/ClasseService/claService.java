package com.example.SchoolApi.services.ClasseService;

import com.example.SchoolApi.models.Classe;
import org.springframework.http.ResponseEntity;

public interface claService {
    ResponseEntity<?> getAll();
    ResponseEntity<?> getById(Long id);
<<<<<<< HEAD
    ResponseEntity<?> add(Class classe);
    ResponseEntity<?> update(Class classe, Long id);
    ResponseEntity<?> delete(Long id);
    ResponseEntity<?> findByNom(String Nom);

=======
    ResponseEntity<?> create(Classe classe);
    ResponseEntity<?> update(Classe classe, Long id);
    ResponseEntity<?> delete(Long id);
    ResponseEntity<?> findByNiveau(String niveau);
    ResponseEntity<?> findByNom(String nom);
    ResponseEntity<?> getAllStudent(String nom);
>>>>>>> 91343ac42a09f2f5135eb666d577ad8285239f40
}
