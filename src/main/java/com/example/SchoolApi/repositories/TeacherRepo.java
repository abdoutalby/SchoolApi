package com.example.SchoolApi.repositories;

import com.example.SchoolApi.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepo extends JpaRepository<Teacher,Long> {
}
