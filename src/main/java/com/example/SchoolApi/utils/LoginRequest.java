package com.example.SchoolApi.utils;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}
