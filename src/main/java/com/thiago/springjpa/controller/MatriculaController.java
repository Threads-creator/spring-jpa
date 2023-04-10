package com.thiago.springjpa.controller;

import com.thiago.springjpa.entity.Matricula;
import com.thiago.springjpa.entity.form.MatriculaForm;
import com.thiago.springjpa.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaService matriculaService;

    @PostMapping
    public ResponseEntity<Matricula> create(@Valid @RequestBody MatriculaForm matricula){
        return ResponseEntity.ok().body(matriculaService.save(matricula));
    }

    @GetMapping
    public ResponseEntity<List<Matricula>> getAll(@RequestParam(value = "bairro", required = false) String bairro){
        return ResponseEntity.ok().body(matriculaService.getAll(bairro));
    }
}
