package com.payment.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor

public abstract class Pessoa {
    private String nome;
    private String documento;
    private String endereco;
    private String telefone;
    private String email;
    private String date;

}
