package com.payment.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Data
@Table(name = "tb_empregador")
public class Empregador {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long id;

    private String nome;
    private String documento;
    private String endereco;
    private String telefone;
    private String email;
    private LocalDate dataCriacao;
    private String inscricaoEstadual;
    private String inscricaoMunicipal;


}
