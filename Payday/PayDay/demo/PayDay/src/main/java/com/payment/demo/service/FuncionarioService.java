package com.payment.demo.service;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.demo.model.Dependente;
import com.payment.demo.model.Funcionario;
import com.payment.demo.model.PessoaFisica;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

@Service
public class FuncionarioService {

    @Autowired
    private EventosService eventosService;
    private AdicionaisService adicionaisService;
    private List<Funcionario> funcionarios;

    String jsonFuncionario = "{resources/funcionario.json}";

    public List<Funcionario> carregarFuncionarios() {

        JsonObject jsonObject = new JsonObject();

        System.out.println(jsonObject);
        List<Funcionario> clientList = null;
        try {
            Gson gson = new Gson();
            FileReader reader = new FileReader(
                    "C:\\Users\\gabri\\OneDrive\\Área de Trabalho\\Nova pasta\\PayDay\\Payday\\PayDay\\demo\\PayDay\\src\\main\\resources\\funcionario.json");
            clientList = gson.fromJson(reader, new TypeToken<List<Funcionario>>() {
            }.getType());

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clientList;

    }

    public Optional<Funcionario> buscarPorCPF(String cpf) {
        return funcionarios.stream()
                .filter(funcionario -> funcionario.getDocumento().equals(cpf))
                .findFirst();
    }

    public void executarEvento(Funcionario funcionario, Dependente dependente) {
        // Verifica e executa cada tipo de evento, se estiver presente
        if (funcionario.getEventos().getHoraExtra50() != null) {
            eventosService.adicionarHoraExtra50(funcionario.getNivelSalarial(), funcionario.getEventos().getHoraExtra50());
        }
        if (funcionario.getEventos().getHoraExtra100() != null) {
            eventosService.adicionarHoraExtra100(funcionario.getNivelSalarial(), funcionario.getEventos().getHoraExtra100());
        }
        if (funcionario.getEventos().getFaltas() != null) {
            eventosService.subtrairFaltas(funcionario.getNivelSalarial(), funcionario.getEventos().getFaltas());
        }
        if (funcionario.getEventos().getAtraso() != null) {
            eventosService.descontoPorAtraso(funcionario.getNivelSalarial(), funcionario.getEventos().getAtraso());
        }
        if (funcionario.getEventos().getDescansoSemanalRemunerado() != null) {
            eventosService.descansoSemanalRemunerado(funcionario.getNivelSalarial(),
                    funcionario.getEventos().getDescansoSemanalRemunerado());
        }
        if (funcionario.getEventos().getAdicionalNoturno() != null) {
            eventosService.adicionalNoturno(funcionario.getNivelSalarial(), funcionario.getEventos().getAdicionalNoturno());
        }
        // if (funcionario.getSalarioFamilia() != null) {
        // funcionarioService.salarioFamilia(funcionario.getNivelSalarial(),
        // funcionario.getQuantidadeDependentes());
        // }
        if (funcionario.getEventos().getDiariaViagem() != null) {
            eventosService.diariaViagem(funcionario.getNivelSalarial(), funcionario.getEventos().getDiariaViagem());
        }
        if (funcionario.getEventos().getAuxilioCrecheBaba() != null) {
            eventosService.auxilioCrecheBaba(dependente.getDataDeNascimento(), funcionario.getQuantidadeDependentes());
        }
    }

    public void executarAdicionais(Funcionario funcionario) {
        
        if (funcionario.getAdicionais().getInsalubridade() != null) {
            adicionaisService.adicionarInsalubridade(funcionario.getNivelSalarial());
        }
        if (funcionario.getAdicionais().getPericulosidade() != null) {  
            adicionaisService.adicionarPericulosidade(funcionario.getNivelSalarial());
        }
        if (funcionario.getAdicionais().getAdicionalNoturno() != null) {
            adicionaisService.adicionarNoturno(funcionario.getNivelSalarial());
        }
        if (funcionario.getAdicionais().getChefe() != null) {
            adicionaisService.adicionarGratificacaoChefe(funcionario.getNivelSalarial());
        }
        if (funcionario.getAdicionais().getDiretor() != null) {
            adicionaisService.adicionarGratificacaoDiretor(funcionario.getNivelSalarial());
        }
        if (funcionario.getAdicionais().getPregoeiro() != null) {
            adicionaisService.adicionarGratificacaoPregoeiro(funcionario.getNivelSalarial());
        }
        if (funcionario.getAdicionais().getTempoDeEmpresa() != null) {
            adicionaisService.adicionarTempoDeEmpresa(funcionario.getNivelSalarial(), funcionario.getDataDeContratacao());
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

    public void calcularSalarioLiquido(Funcionario funcionario, PessoaFisica pessoaFisica, Dependente dependente) {

        float salarioBruto = funcionario.getNivelSalarial();
        float eventos = eventosService.getValorTotalEventos();
        float inss = calcularINSS(salarioBruto);
        float fgts = calcularFGTS(salarioBruto);
        float irrf = calcularIRRF(salarioBruto);
        float salarioLiquido = salarioBruto + eventos - inss - fgts - irrf;

        funcionario.setSalarioLiquido(salarioLiquido);
    }

}
