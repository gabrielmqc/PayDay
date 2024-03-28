package com.payment.demo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder

public class Empregador extends Pessoa {
    
    private String inscricaoEstadual;
    private String inscricaoMunicipal;

}
