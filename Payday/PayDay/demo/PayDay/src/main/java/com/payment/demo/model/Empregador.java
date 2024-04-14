package com.payment.demo.model;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class Empregador {
    
    private String nome;
    private String documento;
    private String endereco;
    private String telefone;
    private String email;
    private String dataCriacao;
    private String inscricaoEstadual;
    private String inscricaoMunicipal;

}
