package com.example.SchoolApi.repositories;

import com.example.SchoolApi.models.Class;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface claRepo extends JpaRepository<Class,Long> {
    Optional<Class> findByNom(String Nom);
}
