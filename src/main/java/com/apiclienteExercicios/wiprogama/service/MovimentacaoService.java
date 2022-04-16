package com.apiclienteExercicios.wiprogama.service;

import com.apiclienteExercicios.wiprogama.model.Movimentacao;
import com.apiclienteExercicios.wiprogama.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimentacaoService {

    @Autowired
    MovimentacaoRepository repository;

    public Movimentacao findById(Integer id) {
        Optional<Movimentacao> obj = repository.findById(id);
        return obj.orElse(null);
    }

    public List<Movimentacao> findAll(){
       return repository.findAll();
    }

    public Movimentacao update(Integer id, Movimentacao obj){
        Movimentacao newObj = findById(id);
        newObj.setCartao(obj.getCartao());
        newObj.setValor(obj.getValor());
        return repository.save(obj);
    }

    public Movimentacao create(Movimentacao obj) {
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }


}
