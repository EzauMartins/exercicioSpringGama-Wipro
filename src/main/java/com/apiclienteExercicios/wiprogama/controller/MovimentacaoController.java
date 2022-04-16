package com.apiclienteExercicios.wiprogama.controller;

import com.apiclienteExercicios.wiprogama.model.Movimentacao;
import com.apiclienteExercicios.wiprogama.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {

    @Autowired
    MovimentacaoService service;

    @GetMapping("/{id}")
    public ResponseEntity<Movimentacao> GetById(@PathVariable Integer id){
        Movimentacao mov = this.service.findById(id);
        return ResponseEntity.ok().body(mov);
    }

    @GetMapping
    public ResponseEntity<List<Movimentacao>> GetAll(){
        List<Movimentacao> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Movimentacao> Post(@RequestBody Movimentacao movimentacao){

        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(movimentacao));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movimentacao> Put(@PathVariable Integer id, @RequestBody Movimentacao obj) {
        Movimentacao newMovi = service.update(id, obj);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(newMovi);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
