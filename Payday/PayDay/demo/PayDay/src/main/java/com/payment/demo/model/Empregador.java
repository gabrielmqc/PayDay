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
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@SuperBuilder
@Entity
@Data
@Table(name = "tb_empregador")
public class Empregador extends Pessoa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long id;
    private String inscricaoEstadual;
    private String inscricaoMunicipal;

}
