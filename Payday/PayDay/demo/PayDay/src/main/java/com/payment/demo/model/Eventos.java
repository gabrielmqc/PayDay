package com.payment.demo.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Eventos {

    private String sHoraExtra50;
    private Float horaExtra50;
    private String sHoraExtra100;
    private Float horaExtra100;
    private String sFaltas;
    private Float faltas;
    private String sAtraso;
    private Float atraso;
    private String sDescansoSemanalRemunerado;
    private Float descansoSemanalRemunerado;
    private String sAdicionalNoturno;
    private Float adicionalNoturno;
    private String sSalarioFamilia;
    private Float salarioFamilia;
    private String sDiariaViagem;
    private Float diariaViagem;
    private String sAuxilioCrecheBaba;
    private Float auxilioCrecheBaba;

    public Eventos() {
        // Construtor vazio necessário para Lombok
    }

    
}
