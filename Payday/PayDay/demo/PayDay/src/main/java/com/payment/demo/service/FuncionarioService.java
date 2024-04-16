package com.payment.demo.service;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.demo.model.Dependente;
import com.payment.demo.model.Eventos;
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

    String jsonFuncionario = "{resources/funcionario.json}";

    private List<Funcionario> funcionarios;

    public FuncionarioService() {
        funcionarios = carregarFuncionarios();
    }

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

    public Funcionario buscarPorDocumento(String documento) {

        List<Funcionario> funcionarios = carregarFuncionarios();

        for (Funcionario f : funcionarios) {
            if (f.getDocumento().equals(documento)) {
                return f;
            }
        }

        return null;

    }

    public Funcionario atualizar(Funcionario func) {
    
        Funcionario encontrado = buscarPorDocumento(func.getDocumento());
    
        if(encontrado != null) {
          encontrado.getEventos().setHoraExtra100(func.getEventos().getHoraExtra100()); 
          encontrado.setDocumento(func.getDocumento());
          encontrado.setCargo(func.getCargo());
        }
        return encontrado;
    }

    private Funcionario getByCPF(String cpf) {
        // busca na lista
        for(Funcionario f : funcionarios) {
          if(f.getDocumento().equals(cpf)) {
            return f;
          } 
        }
        return null;
      }

    public Funcionario atualizarEventos(String documento, Eventos novosEventos) {

        // Busca lista de funcionários
        Funcionario funcionario = getByCPF(documento);


        // Verifica se encontrou
        if (funcionario == null) {
            return null;
        }

        // Atualiza os eventos
        if (novosEventos.getHoraExtra50() != null) {
            funcionario.getEventos().setHoraExtra50(novosEventos.getHoraExtra50());
        }

        if (novosEventos.getHoraExtra100() != null) {
            funcionario.getEventos().setHoraExtra100(novosEventos.getHoraExtra100());
        }

        if (novosEventos.getFaltas() != null) {
            funcionario.getEventos().setFaltas(novosEventos.getFaltas());
        }

        if (novosEventos.getAtraso() != null) {
            funcionario.getEventos().setAtraso(novosEventos.getAtraso());
        }

        if (novosEventos.getDescansoSemanalRemunerado() != null) {
            funcionario.getEventos().setDescansoSemanalRemunerado(novosEventos.getDescansoSemanalRemunerado());
        }

        if (novosEventos.getAdicionalNoturno() != null) {
            funcionario.getEventos().setAdicionalNoturno(novosEventos.getAdicionalNoturno());
        }

        // Atualiza outros eventos

        // Obtém index e atualiza na lista
        int index = funcionarios.indexOf(funcionario);
        funcionarios.set(index, funcionario);

        return funcionario;

    }


    public void executarEventos(Funcionario funcionario) {
        // Verifica e executa cada tipo de evento, se estiver presente
        if (funcionario.getEventos().getHoraExtra50() != null) {
            eventosService.adicionarHoraExtra50(funcionario.getNivelSalarial(),
                    funcionario.getEventos().getHoraExtra50());
        }
        if (funcionario.getEventos().getHoraExtra100() != null) {
            eventosService.adicionarHoraExtra100(funcionario.getNivelSalarial(),
                    funcionario.getEventos().getHoraExtra100());
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
            eventosService.adicionalNoturno(funcionario.getNivelSalarial(),
                    funcionario.getEventos().getAdicionalNoturno());
        }
        // if (funcionario.getSalarioFamilia() != null) {
        // funcionarioService.salarioFamilia(funcionario.getNivelSalarial(),
        // funcionario.getQuantidadeDependentes());
        // }
        if (funcionario.getEventos().getDiariaViagem() != null) {
            eventosService.diariaViagem(funcionario.getNivelSalarial(), funcionario.getEventos().getDiariaViagem());
        }
        if (funcionario.getEventos().getAuxilioCrecheBaba() != null) {
            eventosService.auxilioCrecheBaba(funcionario.getDependente().getDataDeNascimento(),
                    funcionario.getQuantidadeDependentes());
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
            adicionaisService.adicionarTempoDeEmpresa(funcionario.getNivelSalarial(),
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

        // Salário líquido
        Float salarioLiquido = salarioBruto - inss - irrf - fgts;

        // Set no funcionário
        funcionario.setSalarioLiquido(salarioLiquido);

    }

}
