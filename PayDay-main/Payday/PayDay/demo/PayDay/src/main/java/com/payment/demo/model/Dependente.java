package com.payment.demo.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor

public class Dependente {
    

    private String nome;
    private String documento;
    private String endereco;
    private String telefone;
    private String email;
    private String dataDeNascimento;
    private String grauDeParentesco;

    public Dependente(){

    }

}
