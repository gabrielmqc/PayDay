package com.payment.demo.model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter


public class Dependente extends Pessoa {
    
    private String tipo;

    public Dependente(String nome, String documento, String endereco, String telefone, String email,
            LocalDate dataDeNascimento, String tipo) {
        super(nome, documento, endereco, telefone, email, dataDeNascimento);
        this.tipo = tipo;
    }


}
