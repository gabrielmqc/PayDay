package com.payment.demo.service;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Service;

import com.payment.demo.model.Adicionais;

@Service
public class AdicionaisService {

    private Adicionais adicionais;

    public AdicionaisService() {
        this.adicionais = new Adicionais();

    }
    /*
     * insalubridade;
     * private float periculosidade;
     * private float adicionalNoturno;
     * private float gratificacao;
     * private float tempoDeEmpresa;
     * private float valeTransporte;
     * private float valeAlimentacao;
     */

    public void adicionarInsalubridade(float nivelSalarial) {
        float insalubridade = adicionais.getInsalubridade();

        insalubridade += nivelSalarial * 0.15;

        adicionais.setInsalubridade(insalubridade);
    }

    public void adicionarPericulosidade(float nivelSalarial) {
        float periculosidade = adicionais.getPericulosidade();

        periculosidade += nivelSalarial * 0.2;

        adicionais.setPericulosidade(periculosidade);
    }

    public void adicionarNoturno(float nivelSalarial) {
        float adicionalNoturno = adicionais.getAdicionalNoturno();

        adicionalNoturno += nivelSalarial * 0.2;

        adicionais.setAdicionalNoturno(adicionalNoturno);
    }

    public void adicionarGratificacaoChefe(float nivelSalarial) {
        float chefe = adicionais.getChefe();

        chefe += nivelSalarial * 0.50;

        adicionais.setChefe(chefe);
    }

    public void adicionarGratificacaoDiretor(float nivelSalarial) {
        float diretor = adicionais.getDiretor();

        diretor += nivelSalarial;

        adicionais.setDiretor(diretor);

    }

    public void adicionarGratificacaoPregoeiro(float nivelSalarial) {
        float pregoeiro = adicionais.getPregoeiro();

        pregoeiro += nivelSalarial * 0.40;

        adicionais.setPregoeiro(pregoeiro);
    }

    public void adicionarTempoDeEmpresa(float nivelSalarial, LocalDate dataDeContratacao) {
        float tempoDeEmpresa = adicionais.getTempoDeEmpresa();
        LocalDate dataAtual = LocalDate.now();
        Period periodo = Period.between(dataDeContratacao, dataAtual);
        int anosDeServico = periodo.getYears();

        tempoDeEmpresa += nivelSalarial * anosDeServico / 100;

        adicionais.setTempoDeEmpresa(tempoDeEmpresa);

    }
}
