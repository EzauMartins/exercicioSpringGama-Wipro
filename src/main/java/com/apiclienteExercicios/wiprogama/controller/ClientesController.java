package com.apiclienteExercicios.wiprogama.controller;

import com.apiclienteExercicios.wiprogama.model.Clientes;
import com.apiclienteExercicios.wiprogama.service.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")

public class ClientesController {

    @Autowired
    private ClientesService service;

    @GetMapping("/{id}")
    public ResponseEntity<Clientes> GetById(@PathVariable Integer id) { // variavel presente na uri

        Clientes obj = this.service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<Clientes>> GetAll() {
        List<Clientes> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Clientes> Post(@RequestBody Clientes clientes) {
        Clientes newObj = service.create(clientes);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(clientes));
    //  return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Clientes> Put(@PathVariable Integer id, @RequestBody Clientes obj) {
        Clientes newUsuario = service.update(id, obj);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(newUsuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
