package com.example.SchoolApi.auth;

import com.example.SchoolApi.config.JWTService;
import com.example.SchoolApi.models.Role;
import com.example.SchoolApi.models.Token;
import com.example.SchoolApi.models.TokenType;
import com.example.SchoolApi.models.User;
import com.example.SchoolApi.repositories.TokenRepo;
import com.example.SchoolApi.repositories.UserRepo;
import com.example.SchoolApi.utils.AuthResponse;
import com.example.SchoolApi.utils.LoginRequest;
import com.example.SchoolApi.utils.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthService {

    final UserRepo userRepo;
    final TokenRepo tokenRepo;
    final JWTService jwtService;
    final AuthenticationManager authenticationManager;
    final PasswordEncoder passwordEncoder;


    public ResponseEntity<?> register(RegisterRequest registerRequest){
        var user= User.builder()
                .username(registerRequest.getUsername())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(registerRequest.isAdmin()? Role.ADMIN:Role.USER)
                .build();
        var savedUser=userRepo.save(user);
        var token=jwtService.generateToken(user);
        saveUserToken(token,savedUser);

      return   ResponseEntity.ok(AuthResponse.builder().token(token).build());


    }

    public void saveUserToken(String token,User user){
        var tokenBuilder=Token.builder()
                .user(user)
                .token(token)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepo.save(tokenBuilder);
    }

    public ResponseEntity<?> login(LoginRequest loginRequest) {
        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),loginRequest.getPassword()));
        var user=userRepo.findByEmail(loginRequest.getEmail()).orElseThrow();
        var token=jwtService.generateToken(user);
        revokeAllUserTokens(user);
        saveUserToken(token,user);
        return ResponseEntity.ok(AuthResponse.builder().token(token).build());

    }

    private void revokeAllUserTokens(User user){
        var tokens=tokenRepo.findAllValidTokenByUser(user);
        if(tokens.isEmpty())
            return;
        tokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepo.saveAll(tokens);
    }
}
