package com.payment.demo.service;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Service;

import com.payment.demo.model.Funcionario;

@Service
public class EventosService {

    private Float valorTotalEventos = 0.0f;
    

    public void adicionarHoraExtra50(Funcionario funcionario, Float nivelSalarial, Float quantiaEventos) {
        float salarioBase = nivelSalarial;
        float eventos = quantiaEventos;
        Float horaExtra = ((salarioBase / 220) * 1.5f) * eventos;
        funcionario.getEventos().setHoraExtra50(horaExtra);
        this.valorTotalEventos += horaExtra;
    }

    public void adicionarHoraExtra100(Funcionario funcionario, Float nivelSalarial, Float quantiaEventos) {
        float salarioBase = nivelSalarial;
        float eventos = quantiaEventos;
        Float horaExtra = ((salarioBase / 220) * 2f) * eventos;
        funcionario.getEventos().setHoraExtra100(horaExtra);
        this.valorTotalEventos += horaExtra;
    }

    public void subtrairFaltas(Funcionario funcionario, Float nivelSalarial, Float quantiaEventos) {
        float salarioBase = nivelSalarial;
        float eventos = quantiaEventos;
        Float faltas = (salarioBase / 30) * eventos;
        funcionario.getEventos().setFaltas(faltas);
        this.valorTotalEventos -= faltas;
    }

    public void descontoPorAtraso(Funcionario funcionario, Float nivelSalarial, Float quantiaEventos) {
        float salarioBase = nivelSalarial;
        float eventos = quantiaEventos;
        Float desconto = (eventos * salarioBase) / 220;
        funcionario.getEventos().setAtraso(desconto);
        this.valorTotalEventos -= desconto;
    }

    public void descansoSemanalRemunerado(Funcionario funcionario, Float nivelSalarial, Float quantiaEventos) {
        float salarioBase = nivelSalarial;
        float eventos = quantiaEventos;
        Float diasFolgaBase = 4f;
        Float diasFolgaAjustados = diasFolgaBase - eventos;
        Float valorDescanso = (salarioBase / 30) * diasFolgaAjustados;
        funcionario.getEventos().setDescansoSemanalRemunerado(valorDescanso);
        this.valorTotalEventos += valorDescanso;
    }

    public void adicionalNoturno(Funcionario funcionario, Float nivelSalarial, Float quantiaEventos) {
        float salarioBase = nivelSalarial;
        float eventos = quantiaEventos;
        Float adicional = ((salarioBase / 220) * 0.2f) * eventos;
        funcionario.getEventos().setAdicionalNoturno(adicional);
        this.valorTotalEventos += adicional;
    }

    public void diariaViagem(Funcionario funcionario, Float nivelSalarial, Float quantiaEventos) {
        float salarioBase = nivelSalarial;
        float eventos = quantiaEventos;
        Float valorDiarias = 400 * eventos;
        Float limiteIntegracao = salarioBase / 2;
        if (valorDiarias > limiteIntegracao) {
            funcionario.getEventos().setDiariaViagem(valorDiarias);
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
