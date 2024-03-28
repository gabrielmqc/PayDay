package com.payment.demo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder

public class PessoaFisica extends Pessoa {
  
    private enum sexo {M, F};
    private String grauDeInstrucao;
    private String nomeDoPai;
    private String nomeDaMae;
    private String raca;
  
}
