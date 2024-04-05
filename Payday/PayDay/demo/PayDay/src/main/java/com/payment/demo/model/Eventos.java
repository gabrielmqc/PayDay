package com.payment.demo.model;

import java.time.LocalDate;
import java.time.Period;

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

    public void adicionarHoraExtra50(float nivelSalarial) {
        this.horaExtra50 += nivelSalarial / 20;
    }

    public void adicionarHoraExtra100(float nivelSalarial) {
        this.horaExtra100 += nivelSalarial / 10;
    }

    public void subtrairFaltas(float nivelSalarial, float quantiaEventos) {
        this.faltas -= (nivelSalarial / 30) * quantiaEventos;
    }

    public void descontoPorAtraso(float nivelSalarial, float quantiaEventos) {
        float desconto = (quantiaEventos * nivelSalarial) / 220;
        this.atraso -= desconto;
    }

    public void descansoSemanalRemunerado(float nivelSalarial, float quantiaEventos) {
        float diasFolgaBase = 4;
        float diasFolgaAjustados = diasFolgaBase - quantiaEventos;
        float valorDescanso = (nivelSalarial / 30) * diasFolgaAjustados;
        this.descansoSemanalRemunerado += valorDescanso;
    }

    public void adicionalNoturno(float nivelSalarial, float quantiaEventos) {
        float adicional = (nivelSalarial / 220) * 0.2f * quantiaEventos;
        this.adicionalNoturno += adicional;
    }

    public void salarioFamilia(float nivelSalarial, int quantidadeDependentes) {
        if (nivelSalarial <= 1819.26) {
            float valorPorFilho = 62.04f;
            this.salarioFamilia += valorPorFilho * quantidadeDependentes;
        }
    }

    public void diariaViagem(float nivelSalarial, float quantiaEventos) {
        float valorDiarias = 400 * quantiaEventos;
        float limiteIntegracao = nivelSalarial / 2;
        if (valorDiarias > limiteIntegracao) {
            this.diariaViagem += valorDiarias;
        }
    }

    public void auxilioCrecheBaba(LocalDate dataDeNascimento, int quantidadeDependentes) {
        float valorPorDependente = 400;
        LocalDate dataAtual = LocalDate.now();
        Period periodo = Period.between(dataDeNascimento, dataAtual);
        int idade = periodo.getYears();
        if(idade < 6) {
            this.auxilioCrecheBaba += valorPorDependente * quantidadeDependentes;
        }
    }
}
