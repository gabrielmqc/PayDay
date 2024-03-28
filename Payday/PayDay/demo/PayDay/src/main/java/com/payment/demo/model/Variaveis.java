package com.payment.demo.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class Variaveis {
    
    private LocalDate periodoInicial;
    private LocalDate periodoFinal;
    private Funcionario funcionario;
    private Eventos evento;
    private String observacao;
    private float quantidadeHoras;

    public Integer cadastrarVariaveis(Integer variavel){
        return variavel;
    }
}
