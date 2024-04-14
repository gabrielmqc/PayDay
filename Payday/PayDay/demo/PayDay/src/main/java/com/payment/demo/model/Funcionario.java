package com.payment.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Funcionario extends PessoaFisica {


    private String nis;
    private String cargo;
    private String jornadaDeTrabalho;
    private String categoria;
    private Float nivelSalarial;
    private Float salarioLiquido;
    private Float quantiaHoraExtra50;
    private Float quantiaHoraExtra100;
    private Float quantiaFaltas;
    private Float quantiaDescontoPorAtraso;
    private Float quantiaDescansoSemanalRemunerado;
    private Float quantiaAdicionalNoturno;
    private int quantidadeDependentes;
    private Float quantiaDiariaViagem;
    private Float quantiaAuxilioCrecheBaba;
    private String dataDeContratacao;
    private Adicionais adicionais;
    


    // Outros métodos da classe aqui
}
