package com.example.SchoolApi.repositories;

import com.example.SchoolApi.models.Token;
import com.example.SchoolApi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TokenRepo extends JpaRepository<Token,Long> {
    Optional<Token> findByToken(String jwt);

    List<Token> findAllValidTokenByUser(User user);
}
