package com.payment.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class Adicionais {
  
    private float insalubridade;
    private float periculosidade;
    private float adicionalNoturno;
    private float chefe;
    private float diretor;
    private float pregoeiro;
    private float tempoDeEmpresa;
    private float valeTransporte;
    private float valeAlimentacao;
    
    public Adicionais() {
        
    }
}
