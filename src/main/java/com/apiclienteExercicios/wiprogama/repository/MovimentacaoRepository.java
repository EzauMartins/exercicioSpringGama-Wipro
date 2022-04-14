package com.apiclienteExercicios.wiprogama.repository;

import com.apiclienteExercicios.wiprogama.model.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao,Integer> {
}
