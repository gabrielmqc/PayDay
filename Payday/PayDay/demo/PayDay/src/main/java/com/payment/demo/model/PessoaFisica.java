package com.payment.demo.model;


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
@Table(name = "tb_pessoa_fisica")
public class PessoaFisica extends Pessoa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sexo;
    private String grauDeInstrucao;
    private String nomeDoPai;
    private String nomeDaMae;
    private String raca;
    private boolean ativoInativo;

    public PessoaFisica(){

    }
  
    
}
