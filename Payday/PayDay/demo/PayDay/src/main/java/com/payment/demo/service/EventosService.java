package com.payment.demo.service;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Service;

@Service
public class EventosService {

    private Float valorTotalEventos;

    public void adicionarHoraExtra50(Float nivelSalarial, Float quantiaEventos) {
        Float horaExtra = nivelSalarial / 220 * 1.5f * quantiaEventos;
        this.valorTotalEventos += horaExtra;
    }

    public void adicionarHoraExtra100(Float nivelSalarial, Float quantiaEventos) {
        Float horaExtra = nivelSalarial / 220 * 2f * quantiaEventos;
        this.valorTotalEventos += horaExtra;
    }

    public void subtrairFaltas(Float nivelSalarial, Float quantiaEventos) {
        Float faltas = nivelSalarial / 30 * quantiaEventos;
        this.valorTotalEventos -= faltas;
    }

    public void descontoPorAtraso(Float nivelSalarial, Float quantiaEventos) {
        Float desconto = (quantiaEventos * nivelSalarial) / 220;
        this.valorTotalEventos -= desconto;
    }

    public void descansoSemanalRemunerado(Float nivelSalarial, Float quantiaEventos) {
        Float diasFolgaBase = 4f;
        Float diasFolgaAjustados = diasFolgaBase - quantiaEventos;
        Float valorDescanso = (nivelSalarial / 30) * diasFolgaAjustados;
        this.valorTotalEventos += valorDescanso;
    }

    public void adicionalNoturno(Float nivelSalarial, Float quantiaEventos) {
        Float adicional = (nivelSalarial / 220) * 0.2f * quantiaEventos;
        this.valorTotalEventos += adicional;
    }

    public void salarioFamilia(Float nivelSalarial, int quantidadeDependentes) {
        if (nivelSalarial <= 1819.26) {
            Float valorPorFilho = 62.04f;
            Float salarioFamilia = valorPorFilho * quantidadeDependentes;
            this.valorTotalEventos += salarioFamilia;
        }
    }

    public void diariaViagem(Float nivelSalarial, Float quantiaEventos) {
        Float valorDiarias = 400 * quantiaEventos;
        Float limiteIntegracao = nivelSalarial / 2;
        if (valorDiarias > limiteIntegracao) {
            this.valorTotalEventos += valorDiarias;
        }
    }

    public void auxilioCrecheBaba(String dataDeNascimento, int quantidadeDependentes) {
        LocalDate dataNascimento = LocalDate.parse(dataDeNascimento);
        LocalDate dataAtual = LocalDate.now();
        Period periodo = Period.between(dataNascimento, dataAtual);
        int idade = periodo.getYears();
        if (idade < 6) {
            Float valorPorDependente = 400f;
            Float auxilioCrecheBaba = valorPorDependente * quantidadeDependentes;
            this.valorTotalEventos += auxilioCrecheBaba;
        }
    }

    public Float getValorTotalEventos() {
        return this.valorTotalEventos;
    }

    public void resetarValorTotalEventos() {
        this.valorTotalEventos = 0f;
    }
}
