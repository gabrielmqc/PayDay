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

    private float valorTotalAdicioanais;
   
    public void adicionarInsalubridade(float nivelSalarial) {
        float insalubridade = adicionais.getInsalubridade();

        insalubridade += nivelSalarial * 0.15;

        adicionais.setInsalubridade(insalubridade);
        this.valorTotalAdicioanais += insalubridade;
    }

    public void adicionarPericulosidade(float nivelSalarial) {
        float periculosidade = adicionais.getPericulosidade();

        periculosidade += nivelSalarial * 0.2;

        adicionais.setPericulosidade(periculosidade);
        this.valorTotalAdicioanais += periculosidade;
    }

    public void adicionarNoturno(float nivelSalarial) {
        float adicionalNoturno = adicionais.getAdicionalNoturno();

        adicionalNoturno += nivelSalarial * 0.2;

        adicionais.setAdicionalNoturno(adicionalNoturno);
        this.valorTotalAdicioanais += adicionalNoturno;
    }

    public void adicionarGratificacaoChefe(float nivelSalarial) {
        float chefe = adicionais.getChefe();

        chefe += nivelSalarial * 0.50;

        adicionais.setChefe(chefe);
        this.valorTotalAdicioanais += chefe;
    }

    public void adicionarGratificacaoDiretor(float nivelSalarial) {
        float diretor = adicionais.getDiretor();

        diretor += nivelSalarial;

        adicionais.setDiretor(diretor);
        this.valorTotalAdicioanais += diretor;

    }

    public void adicionarGratificacaoPregoeiro(float nivelSalarial) {
        float pregoeiro = adicionais.getPregoeiro();

        pregoeiro += nivelSalarial * 0.40;

        adicionais.setPregoeiro(pregoeiro);
        this.valorTotalAdicioanais += pregoeiro;
    }

    public void adicionarTempoDeEmpresa(float nivelSalarial, String dataDeContratacao) {
        LocalDate dataContratacao = LocalDate.parse(dataDeContratacao);
        float tempoDeEmpresa = adicionais.getTempoDeEmpresa();
        LocalDate dataAtual = LocalDate.now();
        Period periodo = Period.between(dataContratacao, dataAtual);
        int anosDeServico = periodo.getYears();

        tempoDeEmpresa += nivelSalarial * anosDeServico / 100;

        adicionais.setTempoDeEmpresa(tempoDeEmpresa);
        this.valorTotalAdicioanais += tempoDeEmpresa;

    }

    public void adicionarValeAlimentacao(float nivelSalarial){
        float valeAlimentacao = 0;
        valeAlimentacao += nivelSalarial * 0.1;
        this.valorTotalAdicioanais -= valeAlimentacao;
    }

    public void adicionarValeTransporte(float nivelSalarial) {
        float valeTransporte = 0;
        valeTransporte += nivelSalarial * 0.06;
        this.valorTotalAdicioanais -= valeTransporte;
    }

    public float getValorTotalAdicionais(){
        return this.valorTotalAdicioanais;
    }

    public void resetarValorTotalAdicionais(){
        this.valorTotalAdicioanais = 0.0f;
    }
}
