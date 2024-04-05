package com.payment.demo.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@AllArgsConstructor
@SuperBuilder
public class Funcionario extends PessoaFisica {
    
    private String nis;
    private String cargo;
    private String jornadaDeTrabalho;
    private String categoria;
    private float nivelSalarial;
    private float quantiaEventos;
    private String tipoEvento;
    private Adicionais adicionais;
    private Eventos eventos;
    private Dependente dependente;
    private int quantidadeDependentes;

    public Funcionario(){

    }

    
    public void salarioLiquido(){
        this.calcularValorLiquido(this.nivelSalarial);
    }
    
    public void executarEvento() {
        switch (tipoEvento) {
            case "HoraExtra50":
                eventos.adicionarHoraExtra50(this.nivelSalarial);
                break;
            case "HoraExtra100":
                eventos.adicionarHoraExtra100(this.nivelSalarial);
                break;
            case "SubtrairFaltas":
                eventos.subtrairFaltas(this.nivelSalarial, this.quantiaEventos);
                break;
            case "DescontoPorAtraso":
                eventos.descontoPorAtraso(this.nivelSalarial, this.quantiaEventos);
                break;
            case "DescansoSemanalRemunerado":
                eventos.descansoSemanalRemunerado(this.nivelSalarial, this.nivelSalarial);
                break;
            case "AdicionalNoturno":
                eventos.adicionalNoturno(this.nivelSalarial, this.nivelSalarial);
                break;
            case "SalarioFamilia":
                eventos.salarioFamilia(this.nivelSalarial, this.quantidadeDependentes);
                break;
            case "DiariaViagem":
                eventos.diariaViagem(this.nivelSalarial, this.quantiaEventos);
                break;
            case "AuxilioCrecheBaba":
                eventos.auxilioCrecheBaba(dependente.getDataDeNascimento(), this.quantidadeDependentes);
                break;
            default:
                System.out.println("Tipo de evento não reconhecido.");
        }
    }

    public float calcularValorLiquido(float nivelSalarial) {
        // Constantes para as alíquotas de INSS e IRRF (valores de 2024)
        final float ALIQUOTA_INSS_FAIXA1 = 0.075f; // Até R$ 2.794,83
        final float ALIQUOTA_INSS_FAIXA2 = 0.09f;  // De R$ 2.794,84 a R$ 5.589,66
        final float ALIQUOTA_INSS_FAIXA3 = 0.12f;  // De R$ 5.589,67 a R$ 10.123,13
        final float ALIQUOTA_INSS_FAIXA_MAXIMA = 713.09f; // Máximo
        
        // Constantes para as faixas de IRRF (valores de 2024)
        final float FAIXA1_LIMITE = 2232.51f;
        final float FAIXA2_LIMITE = 3477.07f;
        final float FAIXA3_LIMITE = 4257.62f;
        final float FAIXA4_LIMITE = 5210.22f;
        
        // Cálculo do desconto do INSS
        float descontoINSS = 0;
        if (nivelSalarial <= 2794.83f) {
            descontoINSS = nivelSalarial * ALIQUOTA_INSS_FAIXA1;
        } else if (nivelSalarial <= 5589.66f) {
            descontoINSS = nivelSalarial * ALIQUOTA_INSS_FAIXA2;
        } else if (nivelSalarial <= 10123.13f) {
            descontoINSS = nivelSalarial * ALIQUOTA_INSS_FAIXA3;
        } else {
            descontoINSS = ALIQUOTA_INSS_FAIXA_MAXIMA;
        }
        
        // Cálculo do desconto do FGTS
        float descontoFGTS = nivelSalarial * 0.08f; // 8%
        
        // Base de cálculo para o IRRF (considerando o desconto do INSS)
        float baseCalculoIRRF = nivelSalarial - descontoINSS;
        
        // Cálculo do desconto do IRRF
        float descontoIRRF = 0;
        if (baseCalculoIRRF > FAIXA1_LIMITE && baseCalculoIRRF <= FAIXA2_LIMITE) {
            descontoIRRF = (baseCalculoIRRF * 0.075f) - 168.36f;
        } else if (baseCalculoIRRF > FAIXA2_LIMITE && baseCalculoIRRF <= FAIXA3_LIMITE) {
            descontoIRRF = (baseCalculoIRRF * 0.15f) - 425.67f;
        } else if (baseCalculoIRRF > FAIXA3_LIMITE && baseCalculoIRRF <= FAIXA4_LIMITE) {
            descontoIRRF = (baseCalculoIRRF * 0.225f) - 763.68f;
        } else if (baseCalculoIRRF > FAIXA4_LIMITE) {
            descontoIRRF = (baseCalculoIRRF * 0.275f) - 1111.57f;
        }
        
        // Cálculo do valor líquido
        float valorLiquido = nivelSalarial - descontoINSS - descontoIRRF - descontoFGTS;
        
        return valorLiquido;
    }

}
