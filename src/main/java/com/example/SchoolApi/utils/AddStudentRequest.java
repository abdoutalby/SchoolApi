package com.example.SchoolApi.utils;

import lombok.Data;

@Data
public class AddStudentRequest {
    private Long idTeacher;
    private Long idStudent;
    private Long idClass;
}
