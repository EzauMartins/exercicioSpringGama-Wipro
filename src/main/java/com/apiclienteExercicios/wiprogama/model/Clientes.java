package com.apiclienteExercicios.wiprogama.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;


@Getter
@Setter
@Entity
public class Clientes implements Serializable{


        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Integer id;

        String nome;

        String email;

        String senha;

        String sobrenome;

        String cartao;

        public Clientes() {
            super();
        }

        public Clientes(String nome, String email, String senha, String sobrenome, String cartao) {
            super();
            this.nome = nome;
            this.email = email;
            this.senha = senha;
            this.sobrenome = sobrenome;
            this.cartao = cartao;
        }
        // getters, setters, hashcode e equals ...
    }


