package com.apiclienteExercicios.wiprogama.controller;

import com.apiclienteExercicios.wiprogama.model.Clientes;
import com.apiclienteExercicios.wiprogama.model.Movimentacao;
import com.apiclienteExercicios.wiprogama.service.MovimentacaoService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {

    @Autowired
    MovimentacaoService service;

    @GetMapping("/{id}")
    public ResponseEntity<Movimentacao> GetById(@PathVariable Integer id){
        Movimentacao obj = this.service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<Movimentacao>> GetAll(){
        List<Movimentacao> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Clientes> Post()

   /* @PostMapping
    public ResponseEntity<Clientes> Post(@RequestBody Clientes clientes) {
        Clientes newObj = service.create(clientes);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(clientes));
        //  return ResponseEntity.created(uri).build();
    }*/
}
