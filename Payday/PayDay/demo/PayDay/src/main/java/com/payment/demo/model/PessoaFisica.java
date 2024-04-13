package com.payment.demo.model;


import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class PessoaFisica {


    private String nome;
    private String documento;
    private String endereco;
    private String telefone;
    private String email;
    private String dataDeNascimento;
    private String sexo;
    private String grauDeInstrucao;
    private String nomeDoPai;
    private String nomeDaMae;
    private String raca;
    private boolean ativoInativo;



    public PessoaFisica(){

    }
  
    
}
