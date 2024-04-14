package com.payment.demo.model;




import lombok.AllArgsConstructor;
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
