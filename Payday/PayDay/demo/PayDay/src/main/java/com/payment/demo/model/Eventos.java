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
    private Funcionario funcionario;

    public Eventos() {
        // Construtor vazio necessário para Lombok
    }

    public void adicionarHoraExtra50(float nivelSalarial) {
        this.horaExtra50 += nivelSalarial / 20; // Calcula o valor da hora extra 50%
    }

    // Método para adicionar hora extra 100%
    public void adicionarHoraExtra100(float nivelSalarial) {
        this.horaExtra100 += nivelSalarial / 10; // Calcula o valor da hora extra 100%
    }

    public void subtrairFaltas(float nivelSalarial) {
        this.faltas -= (nivelSalarial / 30) * 1; // Subtrai o valor equivalente a 2 dias de trabalho
    }

    // Método para calcular desconto por atrasos
    public void descontoPorAtraso(float nivelSalarial, float horasDeAtraso) {
        // Calcula o desconto multiplicando o número de horas de atraso pelo valor da
        // hora de trabalho
        float desconto = (horasDeAtraso * nivelSalarial) / 220; // 220 é a quantidade de horas mensais padrão de
                                                                // trabalho
        this.atraso -= desconto; // Subtrai o desconto do atributo de atrasos
    }

    // Método para calcular descanso semanal remunerado
    public void descansoSemanalRemunerado(float nivelSalarial, float quantidadeFaltas) {
        // Valor base de 4 dias de folga
        float diasFolgaBase = 4;
        // Subtrai 1 dia de folga para cada falta
        float diasFolgaAjustados = diasFolgaBase - quantidadeFaltas;
        // Calcula o valor do descanso semanal remunerado
        float valorDescanso = (nivelSalarial / 30) * diasFolgaAjustados; // 30 é a quantidade de dias em um mês
        this.descansoSemanalRemunerado += valorDescanso; // Adiciona o valor ao atributo correspondente
    }

    // Método para calcular adicional noturno
    public void adicionalNoturno(float nivelSalarial, float horasNoturnas) {
        // Calcula o adicional noturno multiplicando o valor da hora de trabalho pelo
        // percentual de acréscimo (20%)
        float adicional = (nivelSalarial / 220) * 0.2f * horasNoturnas; // 220 é a quantidade de horas mensais padrão de
                                                                        // trabalho
        this.adicionalNoturno += adicional; // Adiciona o adicional noturno ao atributo correspondente
    }

    public void salarioFamilia(float nivelSalarial, int quantidadeDependentes) {
        // Verifica se a renda bruta é menor ou igual a R$ 1.819,26
        if (nivelSalarial <= 1819.26) {
            // Calcula o valor do salário família por filho ou dependente
            float valorPorFilho = 62.04f;
            // Calcula o valor total do salário família
            this.salarioFamilia += valorPorFilho * quantidadeDependentes;
        }
    }

    public void diariaViagem(float nivelSalarial, int diasViagem) {
        // Calcula o valor total das diárias de viagem
        float valorDiarias = 400 * diasViagem;
        // Calcula o valor limite para integração da diária ao salário (50% do salário)
        float limiteIntegracao = nivelSalarial / 2;
        // Verifica se o valor das diárias excede o limite para integração ao salário
        if (valorDiarias > limiteIntegracao) {
            this.diariaViagem += valorDiarias; // Adiciona o valor das diárias ao atributo correspondente
        }
    }

    public void adicionarAuxilioCrecheBaba(float valor) {
        this.auxilioCrecheBaba += valor;
    }

    public void auxilioCrecheBaba(int quantidadeDependentes) {
        // Calcula o valor do auxílio creche/babá para cada dependente com até 6 anos de
        // idade
        float valorPorDependente = 400;
        this.auxilioCrecheBaba += valorPorDependente * quantidadeDependentes; // Adiciona o valor ao atributo
                                                                              // correspondente
    }
}
