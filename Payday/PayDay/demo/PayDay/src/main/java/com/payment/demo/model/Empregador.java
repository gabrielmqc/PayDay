package com.payment.demo.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonDeserialize

public class Empregador {
    
    private String nome;
    private String cnpj;
    private String endereco;
    private String telefone;
    private String email;
    private String dataCriacao;
    private String inscricaoEstadual;
    private String inscricaoMunicipal;


}
