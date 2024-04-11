package com.payment.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.demo.model.Dependente;
import com.payment.demo.model.Eventos;
import com.payment.demo.model.Funcionario;
import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import java.io.File;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class FuncionarioService {

    @Autowired
    private EventosService eventosService;
   
    
    public List<Funcionario> carregarFuncionarios() throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        List<Funcionario> funcionarios = mapper.readValue(new File("resources/funcionarios.json"), new TypeReference<List<Funcionario>>(){});
        return funcionarios;
    
      }

    public void calcularSalarioLiquido(Funcionario funcionario) {
        // Resetar o valor total dos eventos antes de calcular
        eventosService.resetarValorTotalEventos();

        // Executar eventos para o funcionário
        eventosService.adicionarHoraExtra50(funcionario.getNivelSalarial(), funcionario.getQuantiaHoraExtra50());
        eventosService.adicionarHoraExtra100(funcionario.getNivelSalarial(), funcionario.getQuantiaHoraExtra100());
        eventosService.subtrairFaltas(funcionario.getNivelSalarial(), funcionario.getQuantiaFaltas());
        eventosService.descontoPorAtraso(funcionario.getNivelSalarial(), funcionario.getQuantiaDescontoPorAtraso());
        eventosService.descansoSemanalRemunerado(funcionario.getNivelSalarial(),
                funcionario.getQuantiaDescansoSemanalRemunerado());
        eventosService.adicionalNoturno(funcionario.getNivelSalarial(), funcionario.getQuantiaAdicionalNoturno());
        eventosService.salarioFamilia(funcionario.getNivelSalarial(), funcionario.getQuantidadeDependentes());
        eventosService.diariaViagem(funcionario.getNivelSalarial(), funcionario.getQuantiaDiariaViagem());
        eventosService.auxilioCrecheBaba(funcionario.getDataDeNascimento(), funcionario.getQuantidadeDependentes());

        // Obter o valor total dos eventos
        Float valorTotalEventos = eventosService.getValorTotalEventos();

        // Calcular o salário líquido
        Float salarioLiquido = funcionario.getNivelSalarial() + valorTotalEventos;

        // Salvar o salário líquido no funcionário
        funcionario.setSalarioLiquido(salarioLiquido);
    }

    public void executarEvento(Funcionario funcionario, Dependente dependente) {
        // Verifica se o objeto de eventos do funcionário não é nulo
        if (funcionario.getEventos() != null) {
            // Obtém o objeto de eventos do funcionário
            Eventos eventos = funcionario.getEventos();

            // Verifica e executa cada tipo de evento, se estiver presente
            if (eventos.getHoraExtra50() != null) {
                eventosService.adicionarHoraExtra50(funcionario.getNivelSalarial(), eventos.getHoraExtra50());
            }
            if (eventos.getHoraExtra100() != null) {
                eventosService.adicionarHoraExtra100(funcionario.getNivelSalarial(), eventos.getHoraExtra100());
            }
            if (eventos.getFaltas() != null) {
                eventosService.subtrairFaltas(funcionario.getNivelSalarial(), eventos.getFaltas());
            }
            if (eventos.getAtraso() != null) {
                eventosService.descontoPorAtraso(funcionario.getNivelSalarial(), eventos.getAtraso());
            }
            if (eventos.getDescansoSemanalRemunerado() != null) {
                eventosService.descansoSemanalRemunerado(funcionario.getNivelSalarial(),
                        eventos.getDescansoSemanalRemunerado());
            }
            if (eventos.getAdicionalNoturno() != null) {
                eventosService.adicionalNoturno(funcionario.getNivelSalarial(), eventos.getAdicionalNoturno());
            }
            if (eventos.getSalarioFamilia() != null) {
                eventosService.salarioFamilia(funcionario.getNivelSalarial(), funcionario.getQuantidadeDependentes());
            }
            if (eventos.getDiariaViagem() != null) {
                eventosService.diariaViagem(funcionario.getNivelSalarial(), eventos.getDiariaViagem());
            }
            if (eventos.getAuxilioCrecheBaba() != null) {
                eventosService.auxilioCrecheBaba(dependente.getDataDeNascimento(),
                        funcionario.getQuantidadeDependentes());
            }
        } else {
            System.out.println("O objeto de eventos do funcionário está nulo.");
        }
    }

}
