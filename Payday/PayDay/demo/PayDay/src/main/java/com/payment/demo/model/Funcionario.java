package com.payment.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@SuperBuilder
public class Funcionario extends PessoaFisica {

    private String nis;
    private String cargo;
    private String jornadaDeTrabalho;
    private String categoria;
    private float nivelSalarial;
    private float salarioLiquido;
    
    // Quantidades de eventos
    private Float quantiaHoraExtra50;
    private Float quantiaHoraExtra100;
    private float quantiaFaltas;
    private float quantiaDescontoPorAtraso;
    private float quantiaDescansoSemanalRemunerado;
    private float quantiaAdicionalNoturno;
    private int quantidadeDependentes;
    private float quantiaDiariaViagem;
    private float quantiaAuxilioCrecheBaba;

    private LocalDate dataDeContratacao;
    private Adicionais adicionais;
    private Eventos eventos;
    private Dependente dependente;

    // Construtor vazio
    public Funcionario() {
        
    }

    // Outros métodos da classe aqui
}
