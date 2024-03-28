package com.payment.demo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@SuperBuilder

public class Dependente extends Pessoa {
    
    private String tipo;


}
