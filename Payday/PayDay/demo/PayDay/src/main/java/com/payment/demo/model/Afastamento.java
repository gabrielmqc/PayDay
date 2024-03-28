package com.payment.demo.model;

public class Afastamento {
    
    Funcionario funcionario;
    private String tipoAfastamento;
    
    public Afastamento(Funcionario funcionario, String tipoAfastamento) {
        this.funcionario = funcionario;
        this.tipoAfastamento = tipoAfastamento;
    }
    public Funcionario getFuncionario() {
        return funcionario;
    }
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    public String getTipoAfastamento() {
        return tipoAfastamento;
    }
    public void setTipoAfastamento(String tipoAfastamento) {
        this.tipoAfastamento = tipoAfastamento;
    }
    
}
