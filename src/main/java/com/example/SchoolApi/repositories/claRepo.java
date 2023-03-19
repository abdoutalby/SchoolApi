package com.example.SchoolApi.repositories;

import com.example.SchoolApi.models.Classe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface  claRepo extends JpaRepository<Classe,Long> {
    List<Classe> findByNiveauClass(String niveau);
    Optional<Classe> findByNomClass(String nom);
    Boolean existsByNomClass(String nom);


}
