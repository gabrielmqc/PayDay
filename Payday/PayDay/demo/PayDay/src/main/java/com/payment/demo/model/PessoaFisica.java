package com.payment.demo.model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter


public class PessoaFisica extends Pessoa {
  
    private enum sexo {M, F};
    private String grauDeInstrucao;
    private String nomeDoPai;
    private String nomeDaMae;
    private String raca;
    
    public PessoaFisica(String nome, String documento, String endereco, String telefone, String email,
            LocalDate dataDeNascimento, String grauDeInstrucao, String nomeDoPai, String nomeDaMae, String raca) {
        super(nome, documento, endereco, telefone, email, dataDeNascimento);
        this.grauDeInstrucao = grauDeInstrucao;
        this.nomeDoPai = nomeDoPai;
        this.nomeDaMae = nomeDaMae;
        this.raca = raca;
    }
  
}
