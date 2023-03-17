package com.example.SchoolApi.repositories;

import com.example.SchoolApi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {


    Optional<User> findByEmail(String username);
}
