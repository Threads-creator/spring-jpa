package com.thiago.springjpa.controller;

import com.thiago.springjpa.entity.Aluno;
import com.thiago.springjpa.entity.AvaliacaoFisica;
import com.thiago.springjpa.entity.form.AlunoForm;
import com.thiago.springjpa.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<Aluno>> getAll(@RequestParam(value = "dataNascimento", required = false) String dataNascimento){
        return ResponseEntity.ok().body(alunoService.getAll(dataNascimento));
    }

    @GetMapping("/avaliacoes/{id}")
    public ResponseEntity<List<AvaliacaoFisica>> getAvaliacoesByAluno(@PathVariable Long id){
        var body = alunoService.getAvaliacoesFisicaByAlunoId(id);
        return ResponseEntity.ok(body);
    }

    @PostMapping
    public ResponseEntity<Aluno> create(@Valid @RequestBody AlunoForm alunoForm){
        var body = alunoService.create(alunoForm);
        return ResponseEntity.ok(body);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> update(@PathVariable(value = "id") Long id, @Valid @RequestBody AlunoForm alunoForm){
        var aluno = alunoService.update(id, alunoForm);
        if(aluno == null){
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok().body(aluno);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id){
        boolean deletado = alunoService.delete(id);
        if(!deletado){
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok().build();
    }

}
