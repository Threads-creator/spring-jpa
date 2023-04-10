package com.thiago.springjpa.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class StartController {

    @GetMapping
    public ResponseEntity<String> getWelcomeAPI(){
        return ResponseEntity.ok().body("Bem vindo a página inicial da API!!");
    }
}
