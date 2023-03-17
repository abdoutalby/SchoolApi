package com.example.SchoolApi.utils;

import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String email;
    private String password;
    private boolean isAdmin;


}
