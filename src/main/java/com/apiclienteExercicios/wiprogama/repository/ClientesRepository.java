package com.apiclienteExercicios.wiprogama.repository;

import com.apiclienteExercicios.wiprogama.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Integer> {



}