package com.payment.demo.model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


public class Empregador extends Pessoa {
    
    private String inscricaoEstadual;
    private String inscricaoMunicipal;
    public Empregador(String nome, String documento, String endereco, String telefone, String email,
            LocalDate dataDeNascimento, String inscricaoEstadual, String inscricaoMunicipal) {
        super(nome, documento, endereco, telefone, email, dataDeNascimento);
        this.inscricaoEstadual = inscricaoEstadual;
        this.inscricaoMunicipal = inscricaoMunicipal;
    }

}
