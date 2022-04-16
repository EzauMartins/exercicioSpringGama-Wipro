package com.apiclienteExercicios.wiprogama.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
public class Movimentacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String cartao;

    double valor;

    LocalDate date = LocalDate.now(); // DATA DEVE SE AUTO_PREENCHER NO MOMENTO DA TRANSAÇÃO

    public Movimentacao() {
        super();
    }

    public Movimentacao(Integer id, String cartao, double valor, Date data) {
        super();
        this.id = id;
        this.cartao = cartao;
        this.valor = valor;

    }
}
