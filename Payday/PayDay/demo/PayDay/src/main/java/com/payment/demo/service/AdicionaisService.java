package com.payment.demo.service;

import org.springframework.stereotype.Service;

import com.payment.demo.model.Adicionais;
import com.payment.demo.model.Funcionario;

@Service
public class AdicionaisService {

    private Adicionais adicionais;
    private FuncionarioService funcionarioService;
    private Funcionario funcionario;

    public AdicionaisService() {
        this.adicionais = new Adicionais();
        this.funcionario = new Funcionario();
        this.funcionarioService = new FuncionarioService();
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

    public void adicionarGratificacao(float val){

    }

}
