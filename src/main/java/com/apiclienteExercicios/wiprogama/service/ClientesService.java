package com.apiclienteExercicios.wiprogama.service;

import com.apiclienteExercicios.wiprogama.model.Clientes;
import com.apiclienteExercicios.wiprogama.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientesService {

    @Autowired
    private ClientesRepository repository;


    public Clientes findById(Integer id) {
        Optional<Clientes> obj = repository.findById(id);
        return obj.orElse(null);
    }

    public List<Clientes> findAll() {
        return repository.findAll();
    }

    public Clientes update(Integer id, Clientes obj) {
        Clientes newObj = findById(id);
        newObj.setNome(obj.getNome());
        newObj.setSobrenome(obj.getSobrenome());
        newObj.setEmail(obj.getEmail());
        newObj.setSenha(obj.getSenha());
        return repository.save(newObj);
    }

    public Clientes create(Clientes obj) {
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }


}

