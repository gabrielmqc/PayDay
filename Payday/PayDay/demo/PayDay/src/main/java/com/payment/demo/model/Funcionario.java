package com.payment.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name = "tb_funcionario")
public class Funcionario extends PessoaFisica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
    private LocalDate dataDeContratacao;
    
    @ManyToOne
    @JoinColumn(name = "dependente_id")
    private Dependente dependente;


    // Outros métodos da classe aqui
}
