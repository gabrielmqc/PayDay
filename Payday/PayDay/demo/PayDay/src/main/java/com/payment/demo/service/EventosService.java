package com.payment.demo.service;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Service;

import com.payment.demo.model.Eventos;

@Service
public class EventosService {

    private Eventos eventos;

    public void adicionarHoraExtra50(float nivelSalarial) {
        float horaExtra = eventos.getHoraExtra50();
        horaExtra += nivelSalarial / 20;
        eventos.setHoraExtra50(horaExtra);
    }

    public void adicionarHoraExtra100(float nivelSalarial) {
        float horaExtra = eventos.getHoraExtra100();
        horaExtra += nivelSalarial / 10;
        eventos.setHoraExtra100(horaExtra);
    }

    public void subtrairFaltas(float nivelSalarial, float quantiaEventos) {
        float faltas = eventos.getFaltas();
        faltas -= (nivelSalarial / 30) * quantiaEventos;
        eventos.setFaltas(faltas);
    }

    public void descontoPorAtraso(float nivelSalarial, float quantiaEventos) {
        float atraso = eventos.getAtraso();
        float desconto = (quantiaEventos * nivelSalarial) / 220;
        atraso -= desconto;
        eventos.setAtraso(atraso);
    }

    public void descansoSemanalRemunerado(float nivelSalarial, float quantiaEventos) {
        float descansoSemanalRemunerado = eventos.getDescansoSemanalRemunerado();
        float diasFolgaBase = 4;
        float diasFolgaAjustados = diasFolgaBase - quantiaEventos;
        float valorDescanso = (nivelSalarial / 30) * diasFolgaAjustados;
        descansoSemanalRemunerado += valorDescanso;
        eventos.setDescansoSemanalRemunerado(descansoSemanalRemunerado);
    }

    public void adicionalNoturno(float nivelSalarial, float quantiaEventos) {
        float adicionalNoturno = eventos.getAdicionalNoturno();
        float adicional = (nivelSalarial / 220) * 0.2f * quantiaEventos;
        adicionalNoturno += adicional;
        eventos.setAdicionalNoturno(adicionalNoturno);
    }

    public void salarioFamilia(float nivelSalarial, int quantidadeDependentes) {
        float salarioFamilia = eventos.getSalarioFamilia();
        if (nivelSalarial <= 1819.26) {
            float valorPorFilho = 62.04f;
            salarioFamilia += valorPorFilho * quantidadeDependentes;
            eventos.setSalarioFamilia(salarioFamilia);
        }
    }

    public void diariaViagem(float nivelSalarial, float quantiaEventos) {
        float diariaViagem = eventos.getDiariaViagem();
        float valorDiarias = 400 * quantiaEventos;
        float limiteIntegracao = nivelSalarial / 2;
        if (valorDiarias > limiteIntegracao) {
            diariaViagem += valorDiarias;
            eventos.setDiariaViagem(diariaViagem);
        }
    }

    public void auxilioCrecheBaba(LocalDate dataDeNascimento, int quantidadeDependentes) {
        float auxilioCrecheBaba = eventos.getAuxilioCrecheBaba();
        float valorPorDependente = 400;
        LocalDate dataAtual = LocalDate.now();
        Period periodo = Period.between(dataDeNascimento, dataAtual);
        int idade = periodo.getYears();
        if(idade < 6) {
            auxilioCrecheBaba += valorPorDependente * quantidadeDependentes;
            eventos.setAuxilioCrecheBaba(auxilioCrecheBaba);
        }
    }
}
