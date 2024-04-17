package com.payment.demo.service;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Service;

import com.payment.demo.model.Adicionais;
import com.payment.demo.model.Funcionario;

@Service
public class AdicionaisService {

    private float valorTotalAdicionais = 0.0f;

    public void calcularAdicionais(Funcionario funcionario) {
        Adicionais adicionais = funcionario.getAdicionais();

        if (adicionais != null) {
            float nivelSalarial = funcionario.getNivelSalarial();
            adicionarInsalubridade(adicionais.getInsalubridade(), nivelSalarial);
            adicionarPericulosidade(adicionais.getPericulosidade(), nivelSalarial);
            adicionarNoturno(adicionais.getAdicionalNoturno(), nivelSalarial);
            adicionarGratificacaoChefe(adicionais.getChefe(), nivelSalarial);
            adicionarGratificacaoDiretor(adicionais.getDiretor(), nivelSalarial);
            adicionarGratificacaoPregoeiro(adicionais.getPregoeiro(), nivelSalarial);
            adicionarTempoDeEmpresa(adicionais.getTempoDeEmpresa(), nivelSalarial, funcionario.getDataDeContratacao());
            adicionarValeAlimentacao(nivelSalarial);
            adicionarValeTransporte(nivelSalarial);
        }
    }

    public void adicionarInsalubridade(Float insalubridade, float nivelSalarial) {
        if (insalubridade != null) {
            float valorInsalubridade = nivelSalarial * 0.15f * insalubridade;
            this.valorTotalAdicionais += valorInsalubridade;
        }
    }

    public void adicionarPericulosidade(Float periculosidade, float nivelSalarial) {
        if (periculosidade != null) {
            float valorPericulosidade = nivelSalarial * 0.2f * periculosidade;
            this.valorTotalAdicionais += valorPericulosidade;
        }
    }

    public void adicionarNoturno(Float adicionalNoturno, float nivelSalarial) {
        if (adicionalNoturno != null) {
            float valorAdicionalNoturno = nivelSalarial * 0.2f * adicionalNoturno;
            this.valorTotalAdicionais += valorAdicionalNoturno;
        }
    }

    public void adicionarGratificacaoChefe(Float chefe, float nivelSalarial) {
        if (chefe != null) {
            float valorGratificacaoChefe = nivelSalarial * 0.50f * chefe;
            this.valorTotalAdicionais += valorGratificacaoChefe;
        }
    }

    public void adicionarGratificacaoDiretor(Float diretor, float nivelSalarial) {
        if (diretor != null) {
            float valorGratificacaoDiretor = nivelSalarial * diretor;
            this.valorTotalAdicionais += valorGratificacaoDiretor;
        }
    }

    public void adicionarGratificacaoPregoeiro(Float pregoeiro, float nivelSalarial) {
        if (pregoeiro != null) {
            float valorGratificacaoPregoeiro = nivelSalarial * 0.40f * pregoeiro;
            this.valorTotalAdicionais += valorGratificacaoPregoeiro;
        }
    }

    public void adicionarTempoDeEmpresa(Float tempoDeEmpresa, float nivelSalarial, String dataDeContratacao) {
        if (tempoDeEmpresa != null) {
            LocalDate dataContratacao = LocalDate.parse(dataDeContratacao);
            LocalDate dataAtual = LocalDate.now();
            Period periodo = Period.between(dataContratacao, dataAtual);
            int anosDeServico = periodo.getYears();
            float valorTempoDeEmpresa = nivelSalarial * anosDeServico / 100 * tempoDeEmpresa;
            this.valorTotalAdicionais += valorTempoDeEmpresa;
        }
    }

    public void adicionarValeAlimentacao(float nivelSalarial) {
        float valorValeAlimentacao = nivelSalarial * 0.1f;
        this.valorTotalAdicionais -= valorValeAlimentacao;
    }

    public void adicionarValeTransporte(float nivelSalarial) {
        float valorValeTransporte = nivelSalarial * 0.06f;
        this.valorTotalAdicionais = valorValeTransporte;
    }

    public float getValorTotalAdicionais() {
        return this.valorTotalAdicionais;
    }

    public void resetarValorTotalAdicionais() {
        this.valorTotalAdicionais = 0.0f;
    }
}
