package com.example.SchoolApi.repositories;

import com.example.SchoolApi.models.Class;
import org.springframework.data.jpa.repository.JpaRepository;

public interface claRepo extends JpaRepository<Class,Long> {
}
