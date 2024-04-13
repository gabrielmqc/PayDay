package com.payment.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Funcionario extends PessoaFisica {


    private String nis;
    private String cargo;
    private String jornadaDeTrabalho;
    private String categoria;
    private float nivelSalarial;
    private float salarioLiquido;
    private Float quantiaHoraExtra50;
    private Float quantiaHoraExtra100;
    private float quantiaFaltas;
    private float quantiaDescontoPorAtraso;
    private float quantiaDescansoSemanalRemunerado;
    private float quantiaAdicionalNoturno;
    private int quantidadeDependentes;
    private float quantiaDiariaViagem;
    private float quantiaAuxilioCrecheBaba;
    private String dataDeContratacao;
    


    // Outros métodos da classe aqui
}
