package com.payment.demo.model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaFisica extends Pessoa {
  
    private String sexo;
    private String grauDeInstrucao;
    private String nomeDoPai;
    private String nomeDaMae;
    private String raca;

    public PessoaFisica(String nome, String documento, String endereco, String telefone, String email,
            LocalDate dataDeNascimento, String sexo, String grauDeInstrucao, String nomeDoPai, String nomeDaMae,
            String raca) {
        super(nome, documento, endereco, telefone, email, dataDeNascimento);
        this.sexo = sexo;
        this.grauDeInstrucao = grauDeInstrucao;
        this.nomeDoPai = nomeDoPai;
        this.nomeDaMae = nomeDaMae;
        this.raca = raca;
    }
  
    
}
