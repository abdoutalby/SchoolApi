package com.example.SchoolApi.controllers;

import com.example.SchoolApi.services.ClasseService.claServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Classe")
public class claController {
@Autowired
claServ calServ;
}
