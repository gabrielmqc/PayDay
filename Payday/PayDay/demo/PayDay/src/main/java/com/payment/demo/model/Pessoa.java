package com.payment.demo.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@SuperBuilder
public abstract class Pessoa {

    private String nome;
    private String documento;
    private String endereco;
    private String telefone;
    private String email;
    private LocalDate dataDeNascimento;

    public Pessoa(){

    }

}
