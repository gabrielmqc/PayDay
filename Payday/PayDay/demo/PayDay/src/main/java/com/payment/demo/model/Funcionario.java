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

public class Funcionario extends PessoaFisica {

    private String nis;
    private String cargo;
    private String jornadaDeTrabalho;
    private String categoria;
    private Float nivelSalarial;
    private Float salarioLiquido;
    private Dependente dependente;
    private Eventos eventos;
    private int quantidadeDependentes;
    private String dataDeContratacao;
    private Adicionais adicionais;
    

}
