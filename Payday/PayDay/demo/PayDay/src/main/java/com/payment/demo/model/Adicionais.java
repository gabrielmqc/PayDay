package com.payment.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class Adicionais {
  
    private Float insalubridade;
    private Float periculosidade;
    private Float adicionalNoturno;
    private Float chefe;
    private Float diretor;
    private Float pregoeiro;
    private Float tempoDeEmpresa;
    private Float valeTransporte;
    private Float valeAlimentacao;
    
    public Adicionais() {
        
    }
}
