package com.example.SchoolApi.services.ClasseService;

import com.example.SchoolApi.models.Class;
import org.springframework.http.ResponseEntity;

public interface claService {
    ResponseEntity<?> getAll();
    ResponseEntity<?> getById(Long id);
    ResponseEntity<?> create(Class classe);
    ResponseEntity<?> update(Class classe, Long id);
    ResponseEntity<?> delete(Long id);
}
