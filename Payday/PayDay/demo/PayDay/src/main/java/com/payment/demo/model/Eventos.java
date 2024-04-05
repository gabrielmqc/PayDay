package com.payment.demo.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Eventos {
    private float horaExtra50;
    private float horaExtra100;
    private float faltas;
    private float atraso;
    private float descansoSemanalRemunerado;
    private float adicionalNoturno;
    private float salarioFamilia;
    private float diariaViagem;
    private float auxilioCrecheBaba;

    public Eventos() {
        // Construtor vazio necessário para Lombok
    }

    
}
