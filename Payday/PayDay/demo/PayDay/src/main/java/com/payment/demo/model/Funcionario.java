package com.payment.demo.model;


import java.text.DecimalFormat;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonDeserialize

public class Funcionario extends PessoaFisica {

    private String nis;
    private String cargo;
    private String jornadaDeTrabalho;
    private String categoria;
    private Float nivelSalarial;
    private Float salarioLiquido;
    private Dependente dependente;
    private Eventos eventos;
    private int quantidadeDependentes;
    private String dataDeContratacao;
    private Adicionais adicionais;
    private Float salarioBruto;
    private Float fgts;
    private Float inss;
    private Float irrf;

    @Override
public String toString() {
    DecimalFormat df = new DecimalFormat("#,##0.00");
    String salarioBrutoFormatado = "R$" + df.format(salarioBruto);
    String inssFormatado = "R$" + df.format(inss);
    String irrfFormatado = "R$" + df.format(irrf);
    String fgtsFormatado = "R$" + df.format(fgts);
    String horaExtra50Formatada = "R$" + df.format(this.getEventos().getHoraExtra50());
    String horaExtra100Formatada = "R$" + df.format(this.getEventos().getHoraExtra100());
    String faltasFormatadas = "R$" + df.format(this.getEventos().getFaltas());
    String atrasoFormatado = "R$" + df.format(this.getEventos().getAtraso());
    String descansoSemanalRemuneradoFormatado = "R$" + df.format(this.getEventos().getDescansoSemanalRemunerado());
    String adicionalNoturnoFormatado = "R$" + df.format(this.getEventos().getAdicionalNoturno());
    String diariaViagemFormatada = "R$" + df.format(this.getEventos().getDiariaViagem());
    String salarioLiquidoFormatado = "R$" + df.format(this.getSalarioLiquido());
    
    StringBuilder sb = new StringBuilder();
    sb.append("Holerite do Funcionário: ").append(this.getNome()).append("\n");
    sb.append("CPF: ").append(this.getDocumento()).append("\n");
    sb.append("Cargo: ").append(this.getCargo()).append("\n");
    sb.append("Jornada de Trabalho: ").append(this.getJornadaDeTrabalho()).append("\n");
    sb.append("Salário Bruto: ").append(salarioBrutoFormatado).append("\n");
    sb.append("INSS: ").append(inssFormatado).append("\n");
    sb.append("IRRF: ").append(irrfFormatado).append("\n");
    sb.append("FGTS: ").append(fgtsFormatado).append("\n");
    sb.append("Hora Extra 50: ").append(horaExtra50Formatada).append("\n");
    sb.append("Hora Extra 100: ").append(horaExtra100Formatada).append("\n");
    sb.append("Faltas: ").append(faltasFormatadas).append("\n");
    sb.append("Atraso: ").append(atrasoFormatado).append("\n");
    sb.append("Descanso Semanal Remunerado: ").append(descansoSemanalRemuneradoFormatado).append("\n");
    sb.append("Adicional Noturno: ").append(adicionalNoturnoFormatado).append("\n");
    sb.append("Diária de Viagem: ").append(diariaViagemFormatada).append("\n");
    sb.append("Salário Líquido: ").append(salarioLiquidoFormatado).append("\n");
    return sb.toString();
}

}
