package com.payment.demo.model;


import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter

public class Funcionario extends PessoaFisica {
    
    private String nis;
    private String cargo;
    private String jornadaDeTrabalho;
    private String categoria;
    private float nivelSalarial;
    private Adicionais adicionais;
    public Funcionario(String nome, String documento, String endereco, String telefone, String email,
            LocalDate dataDeNascimento, String sexo, String grauDeInstrucao, String nomeDoPai, String nomeDaMae,
            String raca, String nis, String cargo, String jornadaDeTrabalho, String categoria, float nivelSalarial,
            Adicionais adicionais) {
        super(nome, documento, endereco, telefone, email, dataDeNascimento, sexo, grauDeInstrucao, nomeDoPai, nomeDaMae,
                raca);
        this.nis = nis;
        this.cargo = cargo;
        this.jornadaDeTrabalho = jornadaDeTrabalho;
        this.categoria = categoria;
        this.nivelSalarial = nivelSalarial;
        this.adicionais = adicionais;
    }
    
}
