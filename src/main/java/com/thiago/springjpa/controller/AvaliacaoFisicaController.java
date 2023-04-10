package com.thiago.springjpa.controller;

import com.thiago.springjpa.entity.AvaliacaoFisica;
import com.thiago.springjpa.entity.form.AvaliacaoFisicaForm;
import com.thiago.springjpa.service.AvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {

    @Autowired
    private AvaliacaoFisicaService avaliacaoFisicaService;

    @GetMapping
    public ResponseEntity<List<AvaliacaoFisica>> getAll() {
         return ResponseEntity.ok().body(avaliacaoFisicaService.getAll());
    }

    @GetMapping("/altura")
    public ResponseEntity<List<AvaliacaoFisica>> getAllByAltura(@RequestParam Double minAltura) {
        return ResponseEntity.ok().body(avaliacaoFisicaService.getAllMinAltura(minAltura));
    }

    @GetMapping("/peso")
    public ResponseEntity<List<AvaliacaoFisica>> getAllByPeso(@RequestParam Double minPeso, @RequestParam Double maxPeso) {
        return ResponseEntity.ok().body(avaliacaoFisicaService.getAllByPeso(minPeso, maxPeso));
    }

    @PostMapping
    public ResponseEntity<AvaliacaoFisica> create(@Valid @RequestBody AvaliacaoFisicaForm avaliacaoFisicaForm){
        var body = avaliacaoFisicaService.create(avaliacaoFisicaForm);
        return ResponseEntity.ok().body(body);
    }

    @PutMapping("{id}")
    public ResponseEntity<AvaliacaoFisica> update(@PathVariable Long id, @Valid @RequestBody AvaliacaoFisicaForm avaliacaoFisicaForm){
        var avaliacaoFisica = avaliacaoFisicaService.update(id, avaliacaoFisicaForm);
        if(avaliacaoFisica == null){
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok().body(avaliacaoFisica);
    }

    /*
    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        boolean deletado = avaliacaoFisicaService.delete(id);
        if(!deletado) return ResponseEntity.badRequest().build();

        return ResponseEntity.ok().build();
    }*/
}
