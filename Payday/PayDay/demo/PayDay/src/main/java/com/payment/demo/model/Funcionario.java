package com.payment.demo.model;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@SuperBuilder

public class Funcionario extends Pessoa {

    private String nis;
    private String cargo;
    private String jornadaDeTrabalho;
    private String categoria;
    private String nivelSalarial;
    private Adicionais adicionais;
    
}
