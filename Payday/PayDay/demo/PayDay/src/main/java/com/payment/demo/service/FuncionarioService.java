package com.payment.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.payment.demo.model.Funcionario;
import java.io.File;
import java.io.IOException;

@Service
public class FuncionarioService {

    @Autowired
    private EventosService eventosService;

    @Autowired
    private AdicionaisService adicionaisService;

    private static final String FILE_PATH = "C:\\Users\\gabri\\OneDrive\\Área de Trabalho\\Nova pasta\\PayDay\\Payday\\PayDay\\demo\\PayDay\\src\\main\\resources\\funcionario.json";

    public Funcionario encontrarFuncionarioPorNIS(String nis) {
        try {
            // Carregar dados do arquivo JSON
            ObjectMapper objectMapper = new ObjectMapper();
            List<Funcionario> funcionarios = objectMapper.readValue(new File(FILE_PATH),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, Funcionario.class));

            // Percorre a lista para encontrar o funcionário com o NIS específico
            for (Funcionario funcionario : funcionarios) {
                funcionario.setSalarioLiquido(0f);
                funcionario.getEventos().setAdicionalNoturno(0f);
                funcionario.getEventos().setAtraso(0f);
                funcionario.getEventos().setAuxilioCrecheBaba(0f);
                funcionario.getEventos().setDescansoSemanalRemunerado(0f);
                funcionario.getEventos().setDiariaViagem(0f);
                funcionario.getEventos().setFaltas(0f);
                funcionario.getEventos().setHoraExtra100(0f);
                funcionario.getEventos().setHoraExtra50(0f);
                // zera outros campo

                // Verifica se o NIS do funcionário corresponde ao NIS fornecido
                if (funcionario.getNis().equals(nis)) {
                    // Retorna o funcionário encontrado
                    return funcionario;
                }
            }

            // Retorna null se o funcionário com o NIS especificado não for encontrado
            return null;
        } catch (IOException e) {
            // Lidar com exceções de IO, se necessário
            e.printStackTrace();
            return null;
        }
    }

    public void executarEventos(Funcionario funcionario) {

        eventosService.resetarValorTotalEventos();
        // Verifica e executa cada tipo de evento, se estiver presente
        if (funcionario.getEventos().getHoraExtra50() != null) {
            eventosService.adicionarHoraExtra50(funcionario,funcionario.getNivelSalarial(),
                    funcionario.getEventos().getHoraExtra50());
        }
        if (funcionario.getEventos().getHoraExtra100() != null) {
            eventosService.adicionarHoraExtra100(funcionario, funcionario.getNivelSalarial(),
                    funcionario.getEventos().getHoraExtra100());
        }
        if (funcionario.getEventos().getFaltas() != null) {
            eventosService.subtrairFaltas(funcionario, funcionario.getNivelSalarial(), funcionario.getEventos().getFaltas());
        }
        if (funcionario.getEventos().getAtraso() != null) {
            eventosService.descontoPorAtraso(funcionario, funcionario.getNivelSalarial(), funcionario.getEventos().getAtraso());
        }
        if (funcionario.getEventos().getDescansoSemanalRemunerado() != null) {
            eventosService.descansoSemanalRemunerado(funcionario, funcionario.getNivelSalarial(),
                    funcionario.getEventos().getDescansoSemanalRemunerado());
        }
        if (funcionario.getEventos().getAdicionalNoturno() != null) {
            eventosService.adicionalNoturno(funcionario, funcionario.getNivelSalarial(),
                    funcionario.getEventos().getAdicionalNoturno());
        }
        if (funcionario.getEventos().getDiariaViagem() != null) {
            eventosService.diariaViagem(funcionario, funcionario.getNivelSalarial(), funcionario.getEventos().getDiariaViagem());
        }
        if (funcionario.getEventos().getAuxilioCrecheBaba() != null) {
            eventosService.auxilioCrecheBaba(funcionario.getDependente().getDataDeNascimento(),
                    funcionario.getQuantidadeDependentes());
        }
    }

    public void executarAdicionais(Funcionario funcionario) {

        adicionaisService.resetarValorTotalAdicionais();

        if (funcionario.getAdicionais().getInsalubridade() != null) {
            adicionaisService.adicionarInsalubridade(funcionario.getAdicionais().getInsalubridade(),
                    funcionario.getNivelSalarial());
        }
        if (funcionario.getAdicionais().getPericulosidade() != null) {
            adicionaisService.adicionarPericulosidade(funcionario.getAdicionais().getPericulosidade(),
                    funcionario.getNivelSalarial());
        }
        if (funcionario.getAdicionais().getAdicionalNoturno() != null) {
            adicionaisService.adicionarNoturno(funcionario.getAdicionais().getAdicionalNoturno(),
                    funcionario.getNivelSalarial());
        }
        if (funcionario.getAdicionais().getChefe() != null) {
            adicionaisService.adicionarGratificacaoChefe(funcionario.getAdicionais().getChefe(),
                    funcionario.getNivelSalarial());
        }
        if (funcionario.getAdicionais().getDiretor() != null) {
            adicionaisService.adicionarGratificacaoDiretor(funcionario.getAdicionais().getDiretor(),
                    funcionario.getNivelSalarial());
        }
        if (funcionario.getAdicionais().getPregoeiro() != null) {
            adicionaisService.adicionarGratificacaoPregoeiro(funcionario.getAdicionais().getPregoeiro(),
                    funcionario.getNivelSalarial());
        }
        if (funcionario.getAdicionais().getTempoDeEmpresa() != null) {
            adicionaisService.adicionarTempoDeEmpresa(funcionario.getAdicionais().getTempoDeEmpresa(),
                    funcionario.getNivelSalarial(),
                    funcionario.getDataDeContratacao());
        }
    }

    public static float calcularINSS(float salarioBruto) {
        float inss;
        if (salarioBruto <= 1100) {
            inss = salarioBruto * 0.075f;
        } else if (salarioBruto <= 2203.48) {
            inss = salarioBruto * 0.09f;
        } else if (salarioBruto <= 3305.22) {
            inss = salarioBruto * 0.12f;
        } else if (salarioBruto <= 6433.57) {
            inss = salarioBruto * 0.14f;
        } else {
            inss = 6433.57f * 0.14f;
        }
        return inss;
    }

    public static float calcularFGTS(float salarioBruto) {
        return salarioBruto * 0.08f;
    }

    public static float calcularIRRF(float salarioBruto) {
        float inss = calcularINSS(salarioBruto);
        float salarioBase = salarioBruto - inss;
        float irrf;
        if (salarioBase <= 1903.98) {
            irrf = 0;
        } else if (salarioBase <= 2826.65) {
            irrf = salarioBase * 0.075f - 142.8f;
        } else if (salarioBase <= 3751.05) {
            irrf = salarioBase * 0.15f - 354.8f;
        } else if (salarioBase <= 4664.68) {
            irrf = salarioBase * 0.225f - 636.13f;
        } else {
            irrf = salarioBase * 0.275f - 869.36f;
        }
        return irrf;
    }

    public void calcularSalarioLiquido(Funcionario funcionario) {

        // Chama cálculo de eventos
        executarEventos(funcionario);

        // Chama cálculo de adicionais
        executarAdicionais(funcionario);

        // Obtém salário base
        Float salarioBase = funcionario.getNivelSalarial();

        // Soma valores de eventos e adicionais
        Float eventos = eventosService.getValorTotalEventos();
        Float adicionais = adicionaisService.getValorTotalAdicionais();

        Float salarioBruto = salarioBase + eventos + adicionais;

        
        // Calcula descontos
        Float inss = calcularINSS(salarioBruto);
        Float irrf = calcularIRRF(salarioBruto);
        Float fgts = calcularFGTS(salarioBruto);

        funcionario.setInss(inss);
        funcionario.setFgts(fgts);
        funcionario.setIrrf(irrf);
        funcionario.setSalarioBruto(salarioBruto);
        
        // Salário líquido
        Float salarioLiquido = salarioBruto - inss - irrf - fgts;

        funcionario.setSalarioLiquido(salarioLiquido);

    }

}
