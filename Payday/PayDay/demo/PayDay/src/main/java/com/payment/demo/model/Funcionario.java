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
    private Eventos eventos;
    private int quantidadeDependentes;
    private String dataDeContratacao;
    private Adicionais adicionais;
    


    // Outros métodos da classe aqui
}
