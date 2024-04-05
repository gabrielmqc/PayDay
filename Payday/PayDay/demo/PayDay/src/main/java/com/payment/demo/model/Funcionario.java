package com.payment.demo.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@AllArgsConstructor
@SuperBuilder
public class Funcionario extends PessoaFisica {
    
    private String nis;
    private String cargo;
    private String jornadaDeTrabalho;
    private String categoria;
    private float nivelSalarial;
    private float quantiaEventos;
    private String tipoEvento;
    private Adicionais adicionais;
    private Eventos eventos;
    private Dependente dependente;
    private int quantidadeDependentes;

    public Funcionario(){

    }

}
